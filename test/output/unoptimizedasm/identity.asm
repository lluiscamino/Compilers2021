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
/*t_identity: skip*/
t_identity:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$0, %rsp
/*rtn s0: x*/
	movq	16(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$136, %rsp
/*t1 = 7*/
	movq	$7, %rax
	movq	%rax, -16(%rbp)
/*t2 = - t1*/
	xorq 	%rax, %rax
	movq	-16(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*param t2*/
	movq	-24(%rbp), %rax
	push	%rax
/*t0 = call s0*/
	call	t_identity
	movq	%rax, -8(%rbp)
/*printInt(t0)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t4 = 3*/
	movq	$3, %rax
	movq	%rax, -40(%rbp)
/*param t4*/
	movq	-40(%rbp), %rax
	push	%rax
/*t3 = call s0*/
	call	t_identity
	movq	%rax, -32(%rbp)
/*printInt(t3)*/
	movq	-32(%rbp), %rdi
	call	print_uint64
/*t6 = 4*/
	movq	$4, %rax
	movq	%rax, -56(%rbp)
/*t7 = 7*/
	movq	$7, %rax
	movq	%rax, -64(%rbp)
/*t8 = t6 + t7*/
	movq	-56(%rbp), %rax
	movq	-64(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*param t8*/
	movq	-72(%rbp), %rax
	push	%rax
/*t5 = call s0*/
	call	t_identity
	movq	%rax, -48(%rbp)
/*printInt(t5)*/
	movq	-48(%rbp), %rdi
	call	print_uint64
/*t10 = 2*/
	movq	$2, %rax
	movq	%rax, -88(%rbp)
/*t11 = 2*/
	movq	$2, %rax
	movq	%rax, -96(%rbp)
/*if t10 = t11 goto e0*/
	movq	-88(%rbp), %rax
	movq	-96(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e0
1:
/*t12 = 0*/
	movq	$0, %rax
	movq	%rax, -104(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t12 = -1*/
	movq	$-1, %rax
	movq	%rax, -104(%rbp)
/*e1: skip*/
e1:
/*if t12 = 0 goto e2*/
	movq	-104(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e2
1:
/*t14 = 3*/
	movq	$3, %rax
	movq	%rax, -120(%rbp)
/*t13 = t14*/
	movq	-120(%rbp), %rax
	movq	%rax, -112(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t15 = 2*/
	movq	$2, %rax
	movq	%rax, -128(%rbp)
/*t16 = - t15*/
	xorq 	%rax, %rax
	movq	-128(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -136(%rbp)
/*t13 = t16*/
	movq	-136(%rbp), %rax
	movq	%rax, -112(%rbp)
/*e3: skip*/
e3:
/*param t13*/
	movq	-112(%rbp), %rax
	push	%rax
/*t9 = call s0*/
	call	t_identity
	movq	%rax, -80(%rbp)
/*printInt(t9)*/
	movq	-80(%rbp), %rdi
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
