.section	__TEXT, __text
	.globl	_main
	.globl	print_uint64
	.globl	print_boolean
	.globl	print_string
	.globl	read_string
	.globl	string_length
	.globl	compare_strings
print_uint64:
	lea 	-1(%rsp), %rsi
	movb	$'\n', (%rsi)
	mov 	$10, %ecx
	movl	%edi, %ebx
	testl	%edi, %edi
	jns 	.print_uint64_positive
	neg 	%edi

.print_uint64_positive:
	mov 	%rdi, %rax

.Ltoascii_digit:
	xor 	%edx, %edx
	div 	%rcx
	add 	$'0', %edx
	dec 	%rsi
	mov 	%dl, (%rsi)
	test	%rax, %rax
	jnz 	.Ltoascii_digit
	testl	%ebx, %ebx
	jns 	.print_uint64_end
	xor 	%edx, %edx
	div 	%rcx
	add 	$'-', %edx
	dec 	%rsi
	mov 	%dl, (%rsi)
	test 	%rax, %rax

.print_uint64_end:
	mov 	$0x02000004, %eax
	mov 	$1, %edi
	mov 	%rsp, %rdx
	sub 	%rsi, %rdx
	syscall
	ret

/**
 * Prints a boolean to stdout
 * Params:
 * - %rbx: Boolean value
 */
print_boolean:
	testl	%ebx, %ebx
	jnz 	.print_boolean_true
	movq	decl_1@GOTPCREL(%rip), %rsi
	jmp 	.print_boolean_end
	.print_boolean_true:
		movq	decl_0@GOTPCREL(%rip), %rsi
	.print_boolean_end:
		call 	print_string
		ret

/**
 * Prints a string to stdout
 * Params:
 * - %rsi: String address
 */
print_string:
	call	string_length
	mov 	$0x02000004, %rax
	mov 	$1, %rdi
	syscall
	ret

/**
 * Reads a string from stdin
 * Params:
 * - %rsi: Address where the string will be saved
 */
read_string:
	mov 	$0x02000003, %rax
	mov 	$0, %rdi
	movq	$140, %rdx
	syscall
	ret

/**
 * Returns a string's length (saves to %rdx)
 * Params:
 * - %rsi: String address
 * https://stackoverflow.com/questions/60482733/how-to-traverse-a-string-in-assembly-until-i-reach-null-strlen-loop
 */
string_length:
	lea 	-1(%rsi), %rdx
	.Lloop:
		inc 	%rdx
		cmpb	$0, (%rdx)
		jne 	.Lloop
	sub 	%rsi, %rdx
	ret

/**
 * Compares two strings (saves result to %rdx)
 * Params:
 * - %rsi: First string address
 * - %rdi: Second string address
 */
compare_strings:
	lea 	-1(%rsi), %rcx
	lea 	-1(%rdi), %rdx
	.Cloop:
		inc 	%rcx
		inc 	%rdx
		cmpb	$0, (%rcx)
		jne 	.compare_strings_continue
		cmpb	$0, (%rdx)
		je  	.compare_strings_true
		.compare_strings_continue:
			movb	(%rcx), %al
			cmpb	%al, (%rdx)
			je  	.Cloop
	.compare_strings_false:
		movq	$0, %rdx
		jmp 	.compare_strings_end
	.compare_strings_true:
		movq	$-1, %rdx
	.compare_strings_end:
		ret

_main:
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	%rbp, (%rsi)
/*t_printNot: skip*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
t_printNot:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$16, %rsp
/*t0 = not value*/
	movq	24(%rbp), %rsi
	movq	(%rsi), %rbx

	notq	%rbx
	movq	%rbx, -16(%rbp)
/*printBoolean(t0)*/
	movq	-16(%rbp), %rbx
	call	print_boolean
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$104, %rsp
/*printBoolean(-1)*/
	movq	$-1, %rbx
	call	print_boolean
/*printBoolean(0)*/
	movq	$0, %rbx
	call	print_boolean
/*param_s -1*/
	movq	decl_3@GOTPCREL(%rip), %rax
	push	%rax
/*call s0*/
	push	$0
	call	t_printNot
/*param_s 0*/
	movq	decl_4@GOTPCREL(%rip), %rax
	push	%rax
/*call s0*/
	push	$0
	call	t_printNot
/*t7 = -1 and 0*/
	movq	$-1, %rax
	movq	$0, %rbx
	andq	%rbx, %rax
	movq	%rax, -8(%rbp)
/*printBoolean(t7)*/
	movq	-8(%rbp), %rbx
	call	print_boolean
/*t10 = -1 or 0*/
	movq	$-1, %rax
	movq	$0, %rbx
	orq 	%rbx, %rax
	movq	%rax, -16(%rbp)
/*printBoolean(t10)*/
	movq	-16(%rbp), %rbx
	call	print_boolean
/*if 3 > 5 goto e0*/
	movq	$3, %rax
	movq	$5, %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*e1: skip*/
e1:
/*if 7 < 9 goto e2*/
	movq	$7, %rax
	movq	$9, %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e2
1:
/*t16 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -32(%rbp)
/*e3: skip*/
e3:
/*t17 = t13 or t16*/
	movq	-24(%rbp), %rax
	movq	-32(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -40(%rbp)
/*printBoolean(t17)*/
	movq	-40(%rbp), %rbx
	call	print_boolean
/*t19 = not -1*/
	movq	$-1, %rbx
	notq	%rbx
	movq	%rbx, -48(%rbp)
/*t21 = not 0*/
	movq	$0, %rbx
	notq	%rbx
	movq	%rbx, -56(%rbp)
/*t22 = t19 or t21*/
	movq	-48(%rbp), %rax
	movq	-56(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -64(%rbp)
/*printBoolean(t22)*/
	movq	-64(%rbp), %rbx
	call	print_boolean
/*if 3 = 3 goto e4*/
	movq	$3, %rax
	movq	$3, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t25 = -1*/
	movq	$-1, %rax
	movq	%rax, -72(%rbp)
/*e5: skip*/
e5:
/*printBoolean(t25)*/
	movq	-72(%rbp), %rbx
	call	print_boolean
/*if 3 = 6 goto e6*/
	movq	$3, %rax
	movq	$6, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*t28 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t28 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e7: skip*/
e7:
/*printBoolean(t28)*/
	movq	-80(%rbp), %rbx
	call	print_boolean
/*if 3 != 5 goto e8*/
	movq	$3, %rax
	movq	$5, %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e8
1:
/*t31 = 0*/
	movq	$0, %rax
	movq	%rax, -88(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t31 = -1*/
	movq	$-1, %rax
	movq	%rax, -88(%rbp)
/*e9: skip*/
e9:
/*if 4 != 6 goto e10*/
	movq	$4, %rax
	movq	$6, %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e10
1:
/*t34 = 0*/
	movq	$0, %rax
	movq	%rax, -96(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t34 = -1*/
	movq	$-1, %rax
	movq	%rax, -96(%rbp)
/*e11: skip*/
e11:
/*t35 = t31 or t34*/
	movq	-88(%rbp), %rax
	movq	-96(%rbp), %rbx
	orq 	%rbx, %rax
	movq	%rax, -104(%rbp)
/*printBoolean(t35)*/
	movq	-104(%rbp), %rbx
	call	print_boolean
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	decl_3: .quad -1
	decl_4: .quad 0
