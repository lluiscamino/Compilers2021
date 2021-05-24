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
/*t_identity: skip*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
t_identity:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*rtn s0: x*/
	movq	16(%rbp), %rsi
	movq	(%rsi), %rax

	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$72, %rsp
/*t2 = - 7*/
	xorq 	%rax, %rax
	movq	$7, %rbx
	subq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*param_s t2*/
	lea 	-16(%rbp), %rax
	push	%rax
/*t0 = call s0*/
	call	t_identity
	movq	%rax, -8(%rbp)
/*printInt(t0)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*param_s 3*/
	movq	decl_3@GOTPCREL(%rip), %rax
	push	%rax
/*t3 = call s0*/
	call	t_identity
	movq	%rax, -24(%rbp)
/*printInt(t3)*/
	movq	-24(%rbp), %rdi
	call	print_uint64
/*t8 = 4 + 7*/
	movq	$4, %rax
	movq	$7, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*param_s t8*/
	lea 	-40(%rbp), %rax
	push	%rax
/*t5 = call s0*/
	call	t_identity
	movq	%rax, -32(%rbp)
/*printInt(t5)*/
	movq	-32(%rbp), %rdi
	call	print_uint64
/*if 2 = 2 goto e0*/
	movq	$2, %rax
	movq	$2, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e0
1:
/*t12 = 0*/
	movq	$0, %rax
	movq	%rax, -56(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t12 = -1*/
	movq	$-1, %rax
	movq	%rax, -56(%rbp)
/*e1: skip*/
e1:
/*if t12 = 0 goto e2*/
	movq	-56(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e2
1:
/*t13 = 3*/
	movq	$3, %rax
	movq	%rax, -64(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t16 = - 2*/
	xorq 	%rax, %rax
	movq	$2, %rbx
	subq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t13 = t16*/
	movq	-72(%rbp), %rax
	movq	%rax, -64(%rbp)
/*e3: skip*/
e3:
/*param_s t13*/
	lea 	-64(%rbp), %rax
	push	%rax
/*t9 = call s0*/
	call	t_identity
	movq	%rax, -48(%rbp)
/*printInt(t9)*/
	movq	-48(%rbp), %rdi
	call	print_uint64
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	decl_3: .quad 3
