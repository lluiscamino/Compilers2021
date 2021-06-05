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
/*t_main: skip*/
t_main:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$608, %rsp
/*t0 = 100*/
	movq	$100, %rax
	movq	%rax, -16(%rbp)
/*t2 = t0 * 8*/
	movq	-16(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t2 = t2 + 8*/
	movq	-32(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t1 = new array[t2]*/
	movq	%rsp, %rbx
	and 	$-16, %rsp
	movq	-32(%rbp), %rdi
	call	_malloc
	movq	%rbx, %rsp
	movq	%rax, -24(%rbp)
/*t1[0] = t0*/
	movq	-24(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	-16(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t3 = 0*/
	movq	$0, %rax
	movq	%rax, -40(%rbp)
/*e0: skip*/
e0:
/*if t3 = t0 goto e1*/
	movq	-40(%rbp), %rax
	movq	-16(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t5 = 100*/
	movq	$100, %rax
	movq	%rax, -56(%rbp)
/*t7 = t5 * 8*/
	movq	-56(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t7 = t7 + 8*/
	movq	-72(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t6 = new array[t7]*/
	movq	%rsp, %rbx
	and 	$-16, %rsp
	movq	-72(%rbp), %rdi
	call	_malloc
	movq	%rbx, %rsp
	movq	%rax, -64(%rbp)
/*t6[0] = t5*/
	movq	-64(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4 = t3 * 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t4 = t4 + 8*/
	movq	-48(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t1[t4] = t6*/
	movq	-24(%rbp), %rcx
	movq	-48(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t3 = t3 + 1*/
	movq	-40(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*goto e0*/
	jmp 	e0
/*e1: skip*/
e1:
/*input = t1*/
	movq	-24(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t8 = 0*/
	movq	$0, %rax
	movq	%rax, -88(%rbp)
/*i = t8*/
	movq	-88(%rbp), %rax
	movq	%rax, -80(%rbp)
/*e2: skip*/
e2:
/*t9 = 100*/
	movq	$100, %rax
	movq	%rax, -96(%rbp)
/*if i < t9 goto e3*/
	movq	-80(%rbp), %rax
	movq	-96(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e3
1:
/*t10 = 0*/
	movq	$0, %rax
	movq	%rax, -104(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t10 = -1*/
	movq	$-1, %rax
	movq	%rax, -104(%rbp)
/*e4: skip*/
e4:
/*if t10 = 0 goto e5*/
	movq	-104(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e5
1:
/*t11 = 0*/
	movq	$0, %rax
	movq	%rax, -120(%rbp)
/*j = t11*/
	movq	-120(%rbp), %rax
	movq	%rax, -112(%rbp)
/*e6: skip*/
e6:
/*t12 = 100*/
	movq	$100, %rax
	movq	%rax, -128(%rbp)
/*if j < t12 goto e7*/
	movq	-112(%rbp), %rax
	movq	-128(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -136(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -136(%rbp)
/*e8: skip*/
e8:
/*if t13 = 0 goto e9*/
	movq	-136(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e9
1:
/*t14 = input*/
	movq	-8(%rbp), %rax
	movq	%rax, -144(%rbp)
/*t15 = i * 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t15 = t15 + 8*/
	movq	-152(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t14 = t14[t15]*/
	movq	-144(%rbp), %rax
	movq	-152(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -144(%rbp)
/*t16 = i * j*/
	movq	-80(%rbp), %rax
	movq	-112(%rbp), %rbx
	imulq	%rbx, %rax
	movq	%rax, -160(%rbp)
/*t15 = j * 8*/
	movq	-112(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t15 = t15 + 8*/
	movq	-152(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t14[t15] = t16*/
	movq	-144(%rbp), %rcx
	movq	-152(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-160(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t17 = 1*/
	movq	$1, %rax
	movq	%rax, -168(%rbp)
/*j = j + t17*/
	movq	-112(%rbp), %rax
	movq	-168(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*goto e6*/
	jmp 	e6
/*e9: skip*/
e9:
/*t18 = 1*/
	movq	$1, %rax
	movq	%rax, -176(%rbp)
/*i = i + t18*/
	movq	-80(%rbp), %rax
	movq	-176(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*goto e2*/
	jmp 	e2
/*e5: skip*/
e5:
/*t19 = 2*/
	movq	$2, %rax
	movq	%rax, -184(%rbp)
/*t20 = t19 * 8*/
	movq	-184(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -192(%rbp)
/*t20 = t20 + 8*/
	movq	-192(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -192(%rbp)
/*t21 = input[t20]*/
	movq	-8(%rbp), %rax
	movq	-192(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -200(%rbp)
/*t22 = 5*/
	movq	$5, %rax
	movq	%rax, -208(%rbp)
/*t23 = t22 * 8*/
	movq	-208(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*t23 = t23 + 8*/
	movq	-216(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*t24 = t21[t23]*/
	movq	-200(%rbp), %rax
	movq	-216(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -224(%rbp)
/*printInt(t24)*/
	movq	-224(%rbp), %rdi
	call	print_uint64
/*t25 = 25*/
	movq	$25, %rax
	movq	%rax, -232(%rbp)
/*t26 = t25 * 8*/
	movq	-232(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -240(%rbp)
/*t26 = t26 + 8*/
	movq	-240(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -240(%rbp)
/*t27 = input[t26]*/
	movq	-8(%rbp), %rax
	movq	-240(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -248(%rbp)
/*t28 = 9*/
	movq	$9, %rax
	movq	%rax, -256(%rbp)
/*t29 = t28 * 8*/
	movq	-256(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -264(%rbp)
/*t29 = t29 + 8*/
	movq	-264(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -264(%rbp)
/*t30 = t27[t29]*/
	movq	-248(%rbp), %rax
	movq	-264(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -272(%rbp)
/*printInt(t30)*/
	movq	-272(%rbp), %rdi
	call	print_uint64
/*t31 = 78*/
	movq	$78, %rax
	movq	%rax, -280(%rbp)
/*t32 = t31 * 8*/
	movq	-280(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -288(%rbp)
/*t32 = t32 + 8*/
	movq	-288(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -288(%rbp)
/*t33 = input[t32]*/
	movq	-8(%rbp), %rax
	movq	-288(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -296(%rbp)
/*t34 = 32*/
	movq	$32, %rax
	movq	%rax, -304(%rbp)
/*t35 = t34 * 8*/
	movq	-304(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -312(%rbp)
/*t35 = t35 + 8*/
	movq	-312(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -312(%rbp)
/*t36 = t33[t35]*/
	movq	-296(%rbp), %rax
	movq	-312(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -320(%rbp)
/*printInt(t36)*/
	movq	-320(%rbp), %rdi
	call	print_uint64
/*t37 = 42*/
	movq	$42, %rax
	movq	%rax, -328(%rbp)
/*t38 = t37 * 8*/
	movq	-328(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -336(%rbp)
/*t38 = t38 + 8*/
	movq	-336(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -336(%rbp)
/*t39 = input[t38]*/
	movq	-8(%rbp), %rax
	movq	-336(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -344(%rbp)
/*t40 = 76*/
	movq	$76, %rax
	movq	%rax, -352(%rbp)
/*t41 = t40 * 8*/
	movq	-352(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -360(%rbp)
/*t41 = t41 + 8*/
	movq	-360(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -360(%rbp)
/*t42 = t39[t41]*/
	movq	-344(%rbp), %rax
	movq	-360(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -368(%rbp)
/*printInt(t42)*/
	movq	-368(%rbp), %rdi
	call	print_uint64
/*t43 = 3*/
	movq	$3, %rax
	movq	%rax, -376(%rbp)
/*t44 = t43 * 8*/
	movq	-376(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -384(%rbp)
/*t44 = t44 + 8*/
	movq	-384(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -384(%rbp)
/*t45 = input[t44]*/
	movq	-8(%rbp), %rax
	movq	-384(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -392(%rbp)
/*t46 = 67*/
	movq	$67, %rax
	movq	%rax, -400(%rbp)
/*t47 = t46 * 8*/
	movq	-400(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -408(%rbp)
/*t47 = t47 + 8*/
	movq	-408(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -408(%rbp)
/*t48 = t45[t47]*/
	movq	-392(%rbp), %rax
	movq	-408(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -416(%rbp)
/*printInt(t48)*/
	movq	-416(%rbp), %rdi
	call	print_uint64
/*t49 = 8*/
	movq	$8, %rax
	movq	%rax, -424(%rbp)
/*t50 = t49 * 8*/
	movq	-424(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -432(%rbp)
/*t50 = t50 + 8*/
	movq	-432(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -432(%rbp)
/*t51 = input[t50]*/
	movq	-8(%rbp), %rax
	movq	-432(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -440(%rbp)
/*t52 = 54*/
	movq	$54, %rax
	movq	%rax, -448(%rbp)
/*t53 = t52 * 8*/
	movq	-448(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -456(%rbp)
/*t53 = t53 + 8*/
	movq	-456(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -456(%rbp)
/*t54 = t51[t53]*/
	movq	-440(%rbp), %rax
	movq	-456(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -464(%rbp)
/*printInt(t54)*/
	movq	-464(%rbp), %rdi
	call	print_uint64
/*t55 = 97*/
	movq	$97, %rax
	movq	%rax, -472(%rbp)
/*t56 = t55 * 8*/
	movq	-472(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -480(%rbp)
/*t56 = t56 + 8*/
	movq	-480(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -480(%rbp)
/*t57 = input[t56]*/
	movq	-8(%rbp), %rax
	movq	-480(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -488(%rbp)
/*t58 = 12*/
	movq	$12, %rax
	movq	%rax, -496(%rbp)
/*t59 = t58 * 8*/
	movq	-496(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -504(%rbp)
/*t59 = t59 + 8*/
	movq	-504(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -504(%rbp)
/*t60 = t57[t59]*/
	movq	-488(%rbp), %rax
	movq	-504(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -512(%rbp)
/*printInt(t60)*/
	movq	-512(%rbp), %rdi
	call	print_uint64
/*t61 = 12*/
	movq	$12, %rax
	movq	%rax, -520(%rbp)
/*t62 = t61 * 8*/
	movq	-520(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -528(%rbp)
/*t62 = t62 + 8*/
	movq	-528(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -528(%rbp)
/*t63 = input[t62]*/
	movq	-8(%rbp), %rax
	movq	-528(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -536(%rbp)
/*t64 = 34*/
	movq	$34, %rax
	movq	%rax, -544(%rbp)
/*t65 = t64 * 8*/
	movq	-544(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -552(%rbp)
/*t65 = t65 + 8*/
	movq	-552(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -552(%rbp)
/*t66 = t63[t65]*/
	movq	-536(%rbp), %rax
	movq	-552(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -560(%rbp)
/*printInt(t66)*/
	movq	-560(%rbp), %rdi
	call	print_uint64
/*t67 = 23*/
	movq	$23, %rax
	movq	%rax, -568(%rbp)
/*t68 = t67 * 8*/
	movq	-568(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -576(%rbp)
/*t68 = t68 + 8*/
	movq	-576(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -576(%rbp)
/*t69 = input[t68]*/
	movq	-8(%rbp), %rax
	movq	-576(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -584(%rbp)
/*t70 = 32*/
	movq	$32, %rax
	movq	%rax, -592(%rbp)
/*t71 = t70 * 8*/
	movq	-592(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -600(%rbp)
/*t71 = t71 + 8*/
	movq	-600(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -600(%rbp)
/*t72 = t69[t71]*/
	movq	-584(%rbp), %rax
	movq	-600(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -608(%rbp)
/*printInt(t72)*/
	movq	-608(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
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
