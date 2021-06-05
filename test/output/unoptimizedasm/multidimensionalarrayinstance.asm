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
	subq	$594, %rsp
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
	movb	$0, %al
	movb	%al, -97(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t10 = -1*/
	movb	$-1, %al
	movb	%al, -97(%rbp)
/*e4: skip*/
e4:
/*if t10 = 0 goto e5*/
	movb	-97(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e5
1:
/*t11 = 0*/
	movq	$0, %rax
	movq	%rax, -113(%rbp)
/*j = t11*/
	movq	-113(%rbp), %rax
	movq	%rax, -105(%rbp)
/*e6: skip*/
e6:
/*t12 = 100*/
	movq	$100, %rax
	movq	%rax, -121(%rbp)
/*if j < t12 goto e7*/
	movq	-105(%rbp), %rax
	movq	-121(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t13 = 0*/
	movb	$0, %al
	movb	%al, -122(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t13 = -1*/
	movb	$-1, %al
	movb	%al, -122(%rbp)
/*e8: skip*/
e8:
/*if t13 = 0 goto e9*/
	movb	-122(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e9
1:
/*t14 = input*/
	movq	-8(%rbp), %rax
	movq	%rax, -130(%rbp)
/*t15 = i * 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t15 = t15 + 8*/
	movq	-138(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t14 = t14[t15]*/
	movq	-130(%rbp), %rax
	movq	-138(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -130(%rbp)
/*t16 = i * j*/
	movq	-80(%rbp), %rax
	movq	-105(%rbp), %rbx
	imulq	%rbx, %rax
	movq	%rax, -146(%rbp)
/*t15 = j * 8*/
	movq	-105(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t15 = t15 + 8*/
	movq	-138(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t14[t15] = t16*/
	movq	-130(%rbp), %rcx
	movq	-138(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-146(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t17 = 1*/
	movq	$1, %rax
	movq	%rax, -154(%rbp)
/*j = j + t17*/
	movq	-105(%rbp), %rax
	movq	-154(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -105(%rbp)
/*goto e6*/
	jmp 	e6
/*e9: skip*/
e9:
/*t18 = 1*/
	movq	$1, %rax
	movq	%rax, -162(%rbp)
/*i = i + t18*/
	movq	-80(%rbp), %rax
	movq	-162(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*goto e2*/
	jmp 	e2
/*e5: skip*/
e5:
/*t19 = 2*/
	movq	$2, %rax
	movq	%rax, -170(%rbp)
/*t20 = t19 * 8*/
	movq	-170(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -178(%rbp)
/*t20 = t20 + 8*/
	movq	-178(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -178(%rbp)
/*t21 = input[t20]*/
	movq	-8(%rbp), %rax
	movq	-178(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -186(%rbp)
/*t22 = 5*/
	movq	$5, %rax
	movq	%rax, -194(%rbp)
/*t23 = t22 * 8*/
	movq	-194(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -202(%rbp)
/*t23 = t23 + 8*/
	movq	-202(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -202(%rbp)
/*t24 = t21[t23]*/
	movq	-186(%rbp), %rax
	movq	-202(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -210(%rbp)
/*printInt(t24)*/
	movq	-210(%rbp), %rdi
	call	print_uint64
/*t25 = 25*/
	movq	$25, %rax
	movq	%rax, -218(%rbp)
/*t26 = t25 * 8*/
	movq	-218(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -226(%rbp)
/*t26 = t26 + 8*/
	movq	-226(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -226(%rbp)
/*t27 = input[t26]*/
	movq	-8(%rbp), %rax
	movq	-226(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -234(%rbp)
/*t28 = 9*/
	movq	$9, %rax
	movq	%rax, -242(%rbp)
/*t29 = t28 * 8*/
	movq	-242(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -250(%rbp)
/*t29 = t29 + 8*/
	movq	-250(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -250(%rbp)
/*t30 = t27[t29]*/
	movq	-234(%rbp), %rax
	movq	-250(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -258(%rbp)
/*printInt(t30)*/
	movq	-258(%rbp), %rdi
	call	print_uint64
/*t31 = 78*/
	movq	$78, %rax
	movq	%rax, -266(%rbp)
/*t32 = t31 * 8*/
	movq	-266(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -274(%rbp)
/*t32 = t32 + 8*/
	movq	-274(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -274(%rbp)
/*t33 = input[t32]*/
	movq	-8(%rbp), %rax
	movq	-274(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -282(%rbp)
/*t34 = 32*/
	movq	$32, %rax
	movq	%rax, -290(%rbp)
/*t35 = t34 * 8*/
	movq	-290(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -298(%rbp)
/*t35 = t35 + 8*/
	movq	-298(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -298(%rbp)
/*t36 = t33[t35]*/
	movq	-282(%rbp), %rax
	movq	-298(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -306(%rbp)
/*printInt(t36)*/
	movq	-306(%rbp), %rdi
	call	print_uint64
/*t37 = 42*/
	movq	$42, %rax
	movq	%rax, -314(%rbp)
/*t38 = t37 * 8*/
	movq	-314(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -322(%rbp)
/*t38 = t38 + 8*/
	movq	-322(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -322(%rbp)
/*t39 = input[t38]*/
	movq	-8(%rbp), %rax
	movq	-322(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -330(%rbp)
/*t40 = 76*/
	movq	$76, %rax
	movq	%rax, -338(%rbp)
/*t41 = t40 * 8*/
	movq	-338(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -346(%rbp)
/*t41 = t41 + 8*/
	movq	-346(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -346(%rbp)
/*t42 = t39[t41]*/
	movq	-330(%rbp), %rax
	movq	-346(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -354(%rbp)
/*printInt(t42)*/
	movq	-354(%rbp), %rdi
	call	print_uint64
/*t43 = 3*/
	movq	$3, %rax
	movq	%rax, -362(%rbp)
/*t44 = t43 * 8*/
	movq	-362(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -370(%rbp)
/*t44 = t44 + 8*/
	movq	-370(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -370(%rbp)
/*t45 = input[t44]*/
	movq	-8(%rbp), %rax
	movq	-370(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -378(%rbp)
/*t46 = 67*/
	movq	$67, %rax
	movq	%rax, -386(%rbp)
/*t47 = t46 * 8*/
	movq	-386(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -394(%rbp)
/*t47 = t47 + 8*/
	movq	-394(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -394(%rbp)
/*t48 = t45[t47]*/
	movq	-378(%rbp), %rax
	movq	-394(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -402(%rbp)
/*printInt(t48)*/
	movq	-402(%rbp), %rdi
	call	print_uint64
/*t49 = 8*/
	movq	$8, %rax
	movq	%rax, -410(%rbp)
/*t50 = t49 * 8*/
	movq	-410(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -418(%rbp)
/*t50 = t50 + 8*/
	movq	-418(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -418(%rbp)
/*t51 = input[t50]*/
	movq	-8(%rbp), %rax
	movq	-418(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -426(%rbp)
/*t52 = 54*/
	movq	$54, %rax
	movq	%rax, -434(%rbp)
/*t53 = t52 * 8*/
	movq	-434(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -442(%rbp)
/*t53 = t53 + 8*/
	movq	-442(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -442(%rbp)
/*t54 = t51[t53]*/
	movq	-426(%rbp), %rax
	movq	-442(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -450(%rbp)
/*printInt(t54)*/
	movq	-450(%rbp), %rdi
	call	print_uint64
/*t55 = 97*/
	movq	$97, %rax
	movq	%rax, -458(%rbp)
/*t56 = t55 * 8*/
	movq	-458(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -466(%rbp)
/*t56 = t56 + 8*/
	movq	-466(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -466(%rbp)
/*t57 = input[t56]*/
	movq	-8(%rbp), %rax
	movq	-466(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -474(%rbp)
/*t58 = 12*/
	movq	$12, %rax
	movq	%rax, -482(%rbp)
/*t59 = t58 * 8*/
	movq	-482(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -490(%rbp)
/*t59 = t59 + 8*/
	movq	-490(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -490(%rbp)
/*t60 = t57[t59]*/
	movq	-474(%rbp), %rax
	movq	-490(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -498(%rbp)
/*printInt(t60)*/
	movq	-498(%rbp), %rdi
	call	print_uint64
/*t61 = 12*/
	movq	$12, %rax
	movq	%rax, -506(%rbp)
/*t62 = t61 * 8*/
	movq	-506(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -514(%rbp)
/*t62 = t62 + 8*/
	movq	-514(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -514(%rbp)
/*t63 = input[t62]*/
	movq	-8(%rbp), %rax
	movq	-514(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -522(%rbp)
/*t64 = 34*/
	movq	$34, %rax
	movq	%rax, -530(%rbp)
/*t65 = t64 * 8*/
	movq	-530(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -538(%rbp)
/*t65 = t65 + 8*/
	movq	-538(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -538(%rbp)
/*t66 = t63[t65]*/
	movq	-522(%rbp), %rax
	movq	-538(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -546(%rbp)
/*printInt(t66)*/
	movq	-546(%rbp), %rdi
	call	print_uint64
/*t67 = 23*/
	movq	$23, %rax
	movq	%rax, -554(%rbp)
/*t68 = t67 * 8*/
	movq	-554(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -562(%rbp)
/*t68 = t68 + 8*/
	movq	-562(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -562(%rbp)
/*t69 = input[t68]*/
	movq	-8(%rbp), %rax
	movq	-562(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -570(%rbp)
/*t70 = 32*/
	movq	$32, %rax
	movq	%rax, -578(%rbp)
/*t71 = t70 * 8*/
	movq	-578(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -586(%rbp)
/*t71 = t71 + 8*/
	movq	-586(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -586(%rbp)
/*t72 = t69[t71]*/
	movq	-570(%rbp), %rax
	movq	-586(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -594(%rbp)
/*printInt(t72)*/
	movq	-594(%rbp), %rdi
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
