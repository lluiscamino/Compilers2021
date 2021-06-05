.section	__TEXT, __text
	.globl	_main
	.globl	read_string
	.globl	compare_strings
	.globl	print_boolean
	.globl	string_length
	.globl	print_string
	.globl	print_uint64
_main:
	push	%rbp
	mov 	%rsp, %rbp
	subq	$16, %rsp
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	%rbp, (%rsi)
/*t0 = 3*/
	movq	$3, %rax
	movq	%rax, -16(%rbp)
/*a = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*init*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
/*t_printA: skip*/
t_printA:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*printInt(a)*/
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	-8(%rsi), %rdi

	call	print_uint64
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_changeA: skip*/
t_changeA:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*a = newA*/
	movq	16(%rbp), %rax
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rsi
	movq	%rax, -8(%rsi)

/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s2*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$16, %rsp
/*call s0*/
	call	t_printA
/*t1 = 9*/
	movq	$9, %rax
	movq	%rax, -8(%rbp)
/*t2 = - t1*/
	xorq 	%rax, %rax
	movq	-8(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*param t2*/
	movq	-16(%rbp), %rax
	push	%rax
/*call s1*/
	call	t_changeA
/*call s0*/
	call	t_printA
/*rtn s2*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

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

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
