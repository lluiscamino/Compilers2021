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
/*param_s t10*/
	movq	-24(%rbp), %rax
	push	%rax
/*param_s t11*/
	movq	-32(%rbp), %rax
	push	%rax
/*param_s t12*/
	movq	-40(%rbp), %rax
	push	%rax
/*param_s t13*/
	movq	-48(%rbp), %rax
	push	%rax
/*param_s t16*/
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
/*param_s t22*/
	movq	-120(%rbp), %rax
	push	%rax
/*param_s t25*/
	movq	-144(%rbp), %rax
	push	%rax
/*param_s t28*/
	movq	-168(%rbp), %rax
	push	%rax
/*param_s t30*/
	movq	-184(%rbp), %rax
	push	%rax
/*param_s t31*/
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
/*param_s t34*/
	movq	-216(%rbp), %rax
	push	%rax
/*param_s t35*/
	movq	-224(%rbp), %rax
	push	%rax
/*param_s t36*/
	movq	-232(%rbp), %rax
	push	%rax
/*param_s t37*/
	movq	-240(%rbp), %rax
	push	%rax
/*param_s t38*/
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
/*param_s t41*/
	movq	-272(%rbp), %rax
	push	%rax
/*param_s t42*/
	movq	-280(%rbp), %rax
	push	%rax
/*param_s t43*/
	movq	-288(%rbp), %rax
	push	%rax
/*param_s t44*/
	movq	-296(%rbp), %rax
	push	%rax
/*param_s t45*/
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
/*param_s t48*/
	movq	-328(%rbp), %rax
	push	%rax
/*param_s t50*/
	movq	-344(%rbp), %rax
	push	%rax
/*param_s t51*/
	movq	-352(%rbp), %rax
	push	%rax
/*param_s t52*/
	movq	-360(%rbp), %rax
	push	%rax
/*param_s t53*/
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
/*param_s t55*/
	movq	-384(%rbp), %rax
	push	%rax
/*param_s t56*/
	movq	-392(%rbp), %rax
	push	%rax
/*param_s t57*/
	movq	-400(%rbp), %rax
	push	%rax
/*param_s t58*/
	movq	-408(%rbp), %rax
	push	%rax
/*param_s t59*/
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
/*param_s t61*/
	movq	-432(%rbp), %rax
	push	%rax
/*param_s t62*/
	movq	-440(%rbp), %rax
	push	%rax
/*param_s t63*/
	movq	-448(%rbp), %rax
	push	%rax
/*param_s t65*/
	movq	-464(%rbp), %rax
	push	%rax
/*param_s t66*/
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
/*param_s t68*/
	movq	-488(%rbp), %rax
	push	%rax
/*param_s t69*/
	movq	-496(%rbp), %rax
	push	%rax
/*param_s t70*/
	movq	-504(%rbp), %rax
	push	%rax
/*param_s t71*/
	movq	-512(%rbp), %rax
	push	%rax
/*param_s t72*/
	movq	-520(%rbp), %rax
	push	%rax
/*t67 = call s3*/
	call	t_max5
	movq	%rax, -480(%rbp)
/*param_s t40*/
	movq	-264(%rbp), %rax
	push	%rax
/*param_s t46*/
	movq	-312(%rbp), %rax
	push	%rax
/*param_s t54*/
	movq	-376(%rbp), %rax
	push	%rax
/*param_s t60*/
	movq	-424(%rbp), %rax
	push	%rax
/*param_s t67*/
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
