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
/*param num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t3 = call s0*/
	call	t_max2
	movq	%rax, -40(%rbp)
/*param num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param t3*/
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
/*param num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t5 = call s1*/
	call	t_max3
	movq	%rax, -48(%rbp)
/*param num4*/
	movq	40(%rbp), %rax
	push	%rax
/*param t5*/
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
/*param num4*/
	movq	40(%rbp), %rax
	push	%rax
/*param num3*/
	movq	32(%rbp), %rax
	push	%rax
/*param num2*/
	movq	24(%rbp), %rax
	push	%rax
/*param num1*/
	movq	16(%rbp), %rax
	push	%rax
/*t7 = call s2*/
	call	t_max4
	movq	%rax, -56(%rbp)
/*param num5*/
	movq	48(%rbp), %rax
	push	%rax
/*param t7*/
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
	subq	$520, %rsp
/*t9 = 12*/
	movq	$12, %rax
	movq	%rax, -16(%rbp)
/*t10 = - t9*/
	xorq 	%rax, %rax
	movq	-16(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*t11 = 45*/
	movq	$45, %rax
	movq	%rax, -32(%rbp)
/*t12 = 23*/
	movq	$23, %rax
	movq	%rax, -40(%rbp)
/*t13 = 9*/
	movq	$9, %rax
	movq	%rax, -48(%rbp)
/*t14 = 12*/
	movq	$12, %rax
	movq	%rax, -56(%rbp)
/*t15 = 7*/
	movq	$7, %rax
	movq	%rax, -64(%rbp)
/*t16 = t14 + t15*/
	movq	-56(%rbp), %rax
	movq	-64(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*param t10*/
	movq	-24(%rbp), %rax
	push	%rax
/*param t11*/
	movq	-32(%rbp), %rax
	push	%rax
/*param t12*/
	movq	-40(%rbp), %rax
	push	%rax
/*param t13*/
	movq	-48(%rbp), %rax
	push	%rax
/*param t16*/
	movq	-72(%rbp), %rax
	push	%rax
/*t8 = call s3*/
	call	t_max5
	movq	%rax, -8(%rbp)
/*printInt(t8)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t18 = 746*/
	movq	$746, %rax
	movq	%rax, -88(%rbp)
/*t19 = 54*/
	movq	$54, %rax
	movq	%rax, -96(%rbp)
/*t20 = t18 - t19*/
	movq	-88(%rbp), %rax
	movq	-96(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -104(%rbp)
/*t21 = 327*/
	movq	$327, %rax
	movq	%rax, -112(%rbp)
/*t22 = t20 + t21*/
	movq	-104(%rbp), %rax
	movq	-112(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t23 = 720*/
	movq	$720, %rax
	movq	%rax, -128(%rbp)
/*t24 = 64*/
	movq	$64, %rax
	movq	%rax, -136(%rbp)
/*t25 = t23 + t24*/
	movq	-128(%rbp), %rax
	movq	-136(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -144(%rbp)
/*t26 = 1027*/
	movq	$1027, %rax
	movq	%rax, -152(%rbp)
/*t27 = 3*/
	movq	$3, %rax
	movq	%rax, -160(%rbp)
/*t28 = t26 / t27*/
	movq	-152(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	-160(%rbp), %rbx
	idivq	%rbx
	movq	%rax, -168(%rbp)
/*t29 = 245*/
	movq	$245, %rax
	movq	%rax, -176(%rbp)
/*t30 = - t29*/
	xorq 	%rax, %rax
	movq	-176(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -184(%rbp)
/*t31 = 920*/
	movq	$920, %rax
	movq	%rax, -192(%rbp)
/*param t22*/
	movq	-120(%rbp), %rax
	push	%rax
/*param t25*/
	movq	-144(%rbp), %rax
	push	%rax
/*param t28*/
	movq	-168(%rbp), %rax
	push	%rax
/*param t30*/
	movq	-184(%rbp), %rax
	push	%rax
/*param t31*/
	movq	-192(%rbp), %rax
	push	%rax
/*t17 = call s3*/
	call	t_max5
	movq	%rax, -80(%rbp)
/*printInt(t17)*/
	movq	-80(%rbp), %rdi
	call	print_uint64
/*t33 = 1*/
	movq	$1, %rax
	movq	%rax, -208(%rbp)
/*t34 = - t33*/
	xorq 	%rax, %rax
	movq	-208(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*t35 = 0*/
	movq	$0, %rax
	movq	%rax, -224(%rbp)
/*t36 = 1*/
	movq	$1, %rax
	movq	%rax, -232(%rbp)
/*t37 = 2*/
	movq	$2, %rax
	movq	%rax, -240(%rbp)
/*t38 = 3*/
	movq	$3, %rax
	movq	%rax, -248(%rbp)
/*param t34*/
	movq	-216(%rbp), %rax
	push	%rax
/*param t35*/
	movq	-224(%rbp), %rax
	push	%rax
/*param t36*/
	movq	-232(%rbp), %rax
	push	%rax
/*param t37*/
	movq	-240(%rbp), %rax
	push	%rax
/*param t38*/
	movq	-248(%rbp), %rax
	push	%rax
/*t32 = call s3*/
	call	t_max5
	movq	%rax, -200(%rbp)
/*printInt(t32)*/
	movq	-200(%rbp), %rdi
	call	print_uint64
/*t41 = 94*/
	movq	$94, %rax
	movq	%rax, -272(%rbp)
/*t42 = 89*/
	movq	$89, %rax
	movq	%rax, -280(%rbp)
/*t43 = 67*/
	movq	$67, %rax
	movq	%rax, -288(%rbp)
/*t44 = 56*/
	movq	$56, %rax
	movq	%rax, -296(%rbp)
/*t45 = 12*/
	movq	$12, %rax
	movq	%rax, -304(%rbp)
/*param t41*/
	movq	-272(%rbp), %rax
	push	%rax
/*param t42*/
	movq	-280(%rbp), %rax
	push	%rax
/*param t43*/
	movq	-288(%rbp), %rax
	push	%rax
/*param t44*/
	movq	-296(%rbp), %rax
	push	%rax
/*param t45*/
	movq	-304(%rbp), %rax
	push	%rax
/*t40 = call s3*/
	call	t_max5
	movq	%rax, -264(%rbp)
/*t47 = 235*/
	movq	$235, %rax
	movq	%rax, -320(%rbp)
/*t48 = - t47*/
	xorq 	%rax, %rax
	movq	-320(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -328(%rbp)
/*t49 = 72*/
	movq	$72, %rax
	movq	%rax, -336(%rbp)
/*t50 = - t49*/
	xorq 	%rax, %rax
	movq	-336(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -344(%rbp)
/*t51 = 43*/
	movq	$43, %rax
	movq	%rax, -352(%rbp)
/*t52 = 85*/
	movq	$85, %rax
	movq	%rax, -360(%rbp)
/*t53 = 32*/
	movq	$32, %rax
	movq	%rax, -368(%rbp)
/*param t48*/
	movq	-328(%rbp), %rax
	push	%rax
/*param t50*/
	movq	-344(%rbp), %rax
	push	%rax
/*param t51*/
	movq	-352(%rbp), %rax
	push	%rax
/*param t52*/
	movq	-360(%rbp), %rax
	push	%rax
/*param t53*/
	movq	-368(%rbp), %rax
	push	%rax
/*t46 = call s3*/
	call	t_max5
	movq	%rax, -312(%rbp)
/*t55 = 45*/
	movq	$45, %rax
	movq	%rax, -384(%rbp)
/*t56 = 32*/
	movq	$32, %rax
	movq	%rax, -392(%rbp)
/*t57 = 98*/
	movq	$98, %rax
	movq	%rax, -400(%rbp)
/*t58 = 23*/
	movq	$23, %rax
	movq	%rax, -408(%rbp)
/*t59 = 84*/
	movq	$84, %rax
	movq	%rax, -416(%rbp)
/*param t55*/
	movq	-384(%rbp), %rax
	push	%rax
/*param t56*/
	movq	-392(%rbp), %rax
	push	%rax
/*param t57*/
	movq	-400(%rbp), %rax
	push	%rax
/*param t58*/
	movq	-408(%rbp), %rax
	push	%rax
/*param t59*/
	movq	-416(%rbp), %rax
	push	%rax
/*t54 = call s3*/
	call	t_max5
	movq	%rax, -376(%rbp)
/*t61 = 65*/
	movq	$65, %rax
	movq	%rax, -432(%rbp)
/*t62 = 67*/
	movq	$67, %rax
	movq	%rax, -440(%rbp)
/*t63 = 23*/
	movq	$23, %rax
	movq	%rax, -448(%rbp)
/*t64 = 43*/
	movq	$43, %rax
	movq	%rax, -456(%rbp)
/*t65 = - t64*/
	xorq 	%rax, %rax
	movq	-456(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -464(%rbp)
/*t66 = 67*/
	movq	$67, %rax
	movq	%rax, -472(%rbp)
/*param t61*/
	movq	-432(%rbp), %rax
	push	%rax
/*param t62*/
	movq	-440(%rbp), %rax
	push	%rax
/*param t63*/
	movq	-448(%rbp), %rax
	push	%rax
/*param t65*/
	movq	-464(%rbp), %rax
	push	%rax
/*param t66*/
	movq	-472(%rbp), %rax
	push	%rax
/*t60 = call s3*/
	call	t_max5
	movq	%rax, -424(%rbp)
/*t68 = 45*/
	movq	$45, %rax
	movq	%rax, -488(%rbp)
/*t69 = 98*/
	movq	$98, %rax
	movq	%rax, -496(%rbp)
/*t70 = 34*/
	movq	$34, %rax
	movq	%rax, -504(%rbp)
/*t71 = 12*/
	movq	$12, %rax
	movq	%rax, -512(%rbp)
/*t72 = 43*/
	movq	$43, %rax
	movq	%rax, -520(%rbp)
/*param t68*/
	movq	-488(%rbp), %rax
	push	%rax
/*param t69*/
	movq	-496(%rbp), %rax
	push	%rax
/*param t70*/
	movq	-504(%rbp), %rax
	push	%rax
/*param t71*/
	movq	-512(%rbp), %rax
	push	%rax
/*param t72*/
	movq	-520(%rbp), %rax
	push	%rax
/*t67 = call s3*/
	call	t_max5
	movq	%rax, -480(%rbp)
/*param t40*/
	movq	-264(%rbp), %rax
	push	%rax
/*param t46*/
	movq	-312(%rbp), %rax
	push	%rax
/*param t54*/
	movq	-376(%rbp), %rax
	push	%rax
/*param t60*/
	movq	-424(%rbp), %rax
	push	%rax
/*param t67*/
	movq	-480(%rbp), %rax
	push	%rax
/*t39 = call s3*/
	call	t_max5
	movq	%rax, -256(%rbp)
/*printInt(t39)*/
	movq	-256(%rbp), %rdi
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
