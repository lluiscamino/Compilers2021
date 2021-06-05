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
	subq	$0, %rsp
	movq	decl_2@GOTPCREL(%rip), %rsi
	movq	%rbp, (%rsi)
/*init*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
/*t_returnPlusOne: skip*/
t_returnPlusOne:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$24, %rsp
/*t0 = 1*/
	movq	$1, %rax
	movq	%rax, -16(%rbp)
/*t1 = value + t0*/
	movq	16(%rbp), %rax
	movq	-16(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*value = t1*/
	movq	-24(%rbp), %rax
	movq	%rax, 16(%rbp)
/*rtn s0: value*/
	movq	16(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$24, %rsp
/*t2 = 24*/
	movq	$24, %rax
	movq	%rax, -16(%rbp)
/*value = t2*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*param value*/
	movq	-8(%rbp), %rax
	push	%rax
/*t3 = call s0*/
	call	t_returnPlusOne
	movq	%rax, -24(%rbp)
/*printInt(t3)*/
	movq	-24(%rbp), %rdi
	call	print_uint64
/*printInt(value)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*rtn s1*/
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
