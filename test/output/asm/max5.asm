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
/*t_max2: skip*/
t_max2:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$32, %rsp
/*if num1 > num2 goto e0*/
	movq	16(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e0
1:
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*goto e1*/
	jmp 	e1
/*e0: skip*/
e0:
/*t0 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*e1: skip*/
e1:
/*if t0 = 0 goto e2*/
	movq	-24(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e2
1:
/*t1 = num1*/
	movq	16(%rbp), %rax
	movq	%rax, -32(%rbp)
/*goto e3*/
	jmp 	e3
/*e2: skip*/
e2:
/*t1 = num2*/
	movq	24(%rbp), %rax
	movq	%rax, -32(%rbp)
/*e3: skip*/
e3:
/*rtn s0: t1*/
	movq	-32(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_max3: skip*/
t_max3:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$40, %rsp
/*param_s num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param_s num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t3 = call s0*/
	call	t_max2
	movq	%rax, -40(%rbp)
/*param_s num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param_s t3*/
	movq	-40(%rbp), %rax
	push	%rax
/*t2 = call s0*/
	call	t_max2
	movq	%rax, -32(%rbp)
/*rtn s1: t2*/
	movq	-32(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_max4: skip*/
t_max4:
/*pmb s2*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$48, %rsp
/*param_s num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param_s num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param_s num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t5 = call s1*/
	call	t_max3
	movq	%rax, -48(%rbp)
/*param_s num4*/
	movq	40(%rbp), %rax
	push	%rax
/*param_s t5*/
	movq	-48(%rbp), %rax
	push	%rax
/*t4 = call s0*/
	call	t_max2
	movq	%rax, -40(%rbp)
/*rtn s2: t4*/
	movq	-40(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_max5: skip*/
t_max5:
/*pmb s3*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$56, %rsp
/*param_s num4*/
	movq	40(%rbp), %rax
	push	%rax
/*param_s num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param_s num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param_s num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t7 = call s2*/
	call	t_max4
	movq	%rax, -56(%rbp)
/*param_s num5*/
	movq	48(%rbp), %rax
	push	%rax
/*param_s t7*/
	movq	-56(%rbp), %rax
	push	%rax
/*t6 = call s0*/
	call	t_max2
	movq	%rax, -48(%rbp)
/*rtn s3: t6*/
	movq	-48(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s4*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$160, %rsp
/*t10 = -12*/
	movq	$-12, %rax
	movq	%rax, -16(%rbp)
/*t16 = 19*/
	movq	$19, %rax
	movq	%rax, -24(%rbp)
/*param_s t10*/
	movq	-16(%rbp), %rax
	push	%rax
/*param_s 45*/
	movq	$45, %rax
	push	%rax
/*param_s 23*/
	movq	$23, %rax
	push	%rax
/*param_s 9*/
	movq	$9, %rax
	push	%rax
/*param_s t16*/
	movq	-24(%rbp), %rax
	push	%rax
/*t8 = call s3*/
	call	t_max5
	movq	%rax, -8(%rbp)
/*printInt(t8)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t20 = 692*/
	movq	$692, %rax
	movq	%rax, -40(%rbp)
/*t22 = t20 + 327*/
	movq	-40(%rbp), %rax
	movq	$327, %rbx
	addq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t25 = 784*/
	movq	$784, %rax
	movq	%rax, -56(%rbp)
/*t28 = 342*/
	movq	$342, %rax
	movq	%rax, -64(%rbp)
/*t30 = -245*/
	movq	$-245, %rax
	movq	%rax, -72(%rbp)
/*param_s t22*/
	movq	-48(%rbp), %rax
	push	%rax
/*param_s t25*/
	movq	-56(%rbp), %rax
	push	%rax
/*param_s t28*/
	movq	-64(%rbp), %rax
	push	%rax
/*param_s t30*/
	movq	-72(%rbp), %rax
	push	%rax
/*param_s 920*/
	movq	$920, %rax
	push	%rax
/*t17 = call s3*/
	call	t_max5
	movq	%rax, -32(%rbp)
/*printInt(t17)*/
	movq	-32(%rbp), %rdi
	call	print_uint64
/*t34 = -1*/
	movq	$-1, %rax
	movq	%rax, -88(%rbp)
/*param_s t34*/
	movq	-88(%rbp), %rax
	push	%rax
/*param_s 0*/
	movq	$0, %rax
	push	%rax
/*param_s 1*/
	movq	$1, %rax
	push	%rax
/*param_s 2*/
	movq	$2, %rax
	push	%rax
/*param_s 3*/
	movq	$3, %rax
	push	%rax
/*t32 = call s3*/
	call	t_max5
	movq	%rax, -80(%rbp)
/*printInt(t32)*/
	movq	-80(%rbp), %rdi
	call	print_uint64
/*param_s 94*/
	movq	$94, %rax
	push	%rax
/*param_s 89*/
	movq	$89, %rax
	push	%rax
/*param_s 67*/
	movq	$67, %rax
	push	%rax
/*param_s 56*/
	movq	$56, %rax
	push	%rax
/*param_s 12*/
	movq	$12, %rax
	push	%rax
/*t40 = call s3*/
	call	t_max5
	movq	%rax, -104(%rbp)
/*t48 = -235*/
	movq	$-235, %rax
	movq	%rax, -120(%rbp)
/*t50 = -72*/
	movq	$-72, %rax
	movq	%rax, -128(%rbp)
/*param_s t48*/
	movq	-120(%rbp), %rax
	push	%rax
/*param_s t50*/
	movq	-128(%rbp), %rax
	push	%rax
/*param_s 43*/
	movq	$43, %rax
	push	%rax
/*param_s 85*/
	movq	$85, %rax
	push	%rax
/*param_s 32*/
	movq	$32, %rax
	push	%rax
/*t46 = call s3*/
	call	t_max5
	movq	%rax, -112(%rbp)
/*param_s 45*/
	movq	$45, %rax
	push	%rax
/*param_s 32*/
	movq	$32, %rax
	push	%rax
/*param_s 98*/
	movq	$98, %rax
	push	%rax
/*param_s 23*/
	movq	$23, %rax
	push	%rax
/*param_s 84*/
	movq	$84, %rax
	push	%rax
/*t54 = call s3*/
	call	t_max5
	movq	%rax, -136(%rbp)
/*t65 = -43*/
	movq	$-43, %rax
	movq	%rax, -152(%rbp)
/*param_s 65*/
	movq	$65, %rax
	push	%rax
/*param_s 67*/
	movq	$67, %rax
	push	%rax
/*param_s 23*/
	movq	$23, %rax
	push	%rax
/*param_s t65*/
	movq	-152(%rbp), %rax
	push	%rax
/*param_s 67*/
	movq	$67, %rax
	push	%rax
/*t60 = call s3*/
	call	t_max5
	movq	%rax, -144(%rbp)
/*param_s 45*/
	movq	$45, %rax
	push	%rax
/*param_s 98*/
	movq	$98, %rax
	push	%rax
/*param_s 34*/
	movq	$34, %rax
	push	%rax
/*param_s 12*/
	movq	$12, %rax
	push	%rax
/*param_s 43*/
	movq	$43, %rax
	push	%rax
/*t67 = call s3*/
	call	t_max5
	movq	%rax, -160(%rbp)
/*param_s t40*/
	movq	-104(%rbp), %rax
	push	%rax
/*param_s t46*/
	movq	-112(%rbp), %rax
	push	%rax
/*param_s t54*/
	movq	-136(%rbp), %rax
	push	%rax
/*param_s t60*/
	movq	-144(%rbp), %rax
	push	%rax
/*param_s t67*/
	movq	-160(%rbp), %rax
	push	%rax
/*t39 = call s3*/
	call	t_max5
	movq	%rax, -96(%rbp)
/*printInt(t39)*/
	movq	-96(%rbp), %rdi
	call	print_uint64
/*rtn s4*/
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
