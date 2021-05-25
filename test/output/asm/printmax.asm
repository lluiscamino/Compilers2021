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
/*t_printMaxInteger: skip*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
t_printMaxInteger:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$88, %rsp
/*if a > b goto e0*/
	movq	16(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t0 = -1*/
	movq	$-1, %rax
	movq	%rax, -48(%rbp)
/*e1: skip*/
e1:
/*if t0 = 0 goto e2*/
	movq	-48(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e2
1:
/*t1 = a*/
	movq	16(%rbp), %rax
	movq	%rax, -56(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t1 = b*/
	movq	24(%rbp), %rax
	movq	%rax, -56(%rbp)
/*e3: skip*/
e3:
/*max = t1*/
	movq	-56(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if c > max goto e4*/
	movq	32(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e4
1:
/*t2 = 0*/
	movq	$0, %rax
	movq	%rax, -64(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t2 = -1*/
	movq	$-1, %rax
	movq	%rax, -64(%rbp)
/*e5: skip*/
e5:
/*if t2 = 0 goto e6*/
	movq	-64(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*t3 = c*/
	movq	32(%rbp), %rax
	movq	%rax, -72(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t3 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -72(%rbp)
/*e7: skip*/
e7:
/*max = t3*/
	movq	-72(%rbp), %rax
	movq	%rax, -40(%rbp)
/*if d > max goto e8*/
	movq	40(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e8
1:
/*t4 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t4 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e9: skip*/
e9:
/*if t4 = 0 goto e10*/
	movq	-80(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e10
1:
/*t5 = d*/
	movq	40(%rbp), %rax
	movq	%rax, -88(%rbp)
/*goto e11*/
	jmp 	e11
/*e10: skip*/
e10:
/*t5 = max*/
	movq	-40(%rbp), %rax
	movq	%rax, -88(%rbp)
/*e11: skip*/
e11:
/*max = t5*/
	movq	-88(%rbp), %rax
	movq	%rax, -40(%rbp)
/*printInt(max)*/
	movq	-40(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$88, %rsp
/*goto e12*/
	jmp 	e12
/*t7 = 4*/
	movq	$4, %rax
	movq	%rax, -8(%rbp)
/*goto e13*/
	jmp 	e13
/*e12: skip*/
e12:
/*t7 = 9*/
	movq	$9, %rax
	movq	%rax, -8(%rbp)
/*e13: skip*/
e13:
/*t11 = - 3*/
	xorq 	%rax, %rax
	movq	$3, %rbx
	subq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*t14 = 4 + 2*/
	movq	$4, %rax
	movq	$2, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*param_s t7*/
	movq	-8(%rbp), %rax
	push	%rax
/*param_s t11*/
	movq	-16(%rbp), %rax
	push	%rax
/*param_s t14*/
	movq	-24(%rbp), %rax
	push	%rax
/*param_s 4*/
	movq	$4, %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t17 = 4*/
	movq	$4, %rax
	movq	%rax, -32(%rbp)
/*goto e15*/
	jmp 	e15
/*e14: skip*/
e14:
/*t17 = 9*/
	movq	$9, %rax
	movq	%rax, -32(%rbp)
/*e15: skip*/
e15:
/*t21 = - 3*/
	xorq 	%rax, %rax
	movq	$3, %rbx
	subq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t24 = 4 + 2*/
	movq	$4, %rax
	movq	$2, %rbx
	addq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*param_s t17*/
	movq	-32(%rbp), %rax
	push	%rax
/*param_s t21*/
	movq	-40(%rbp), %rax
	push	%rax
/*param_s t24*/
	movq	-48(%rbp), %rax
	push	%rax
/*param_s 4*/
	movq	$4, %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t27 = - 27*/
	xorq 	%rax, %rax
	movq	$27, %rbx
	subq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*t29 = - 23*/
	xorq 	%rax, %rax
	movq	$23, %rbx
	subq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t31 = - 45*/
	xorq 	%rax, %rax
	movq	$45, %rbx
	subq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t33 = - 34*/
	xorq 	%rax, %rax
	movq	$34, %rbx
	subq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*param_s t27*/
	movq	-56(%rbp), %rax
	push	%rax
/*param_s t29*/
	movq	-64(%rbp), %rax
	push	%rax
/*param_s t31*/
	movq	-72(%rbp), %rax
	push	%rax
/*param_s t33*/
	movq	-80(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*t35 = - 23231*/
	xorq 	%rax, %rax
	movq	$23231, %rbx
	subq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*param_s t35*/
	movq	-88(%rbp), %rax
	push	%rax
/*param_s 12323*/
	movq	$12323, %rax
	push	%rax
/*param_s 1212*/
	movq	$1212, %rax
	push	%rax
/*param_s 897137132*/
	movq	$897137132, %rax
	push	%rax
/*call s0*/
	call	t_printMaxInteger
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
