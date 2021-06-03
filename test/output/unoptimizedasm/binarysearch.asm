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
/*t_binarySearch: skip*/
t_binarySearch:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$248, %rsp
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*left = t0*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*t1 = nums[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*t2 = 1*/
	movq	$1, %rax
	movq	%rax, -56(%rbp)
/*t3 = t1 - t2*/
	movq	-48(%rbp), %rax
	movq	-56(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*right = t3*/
	movq	-64(%rbp), %rax
	movq	%rax, -40(%rbp)
/*t4 = 1*/
	movq	$1, %rax
	movq	%rax, -80(%rbp)
/*t5 = - t4*/
	xorq 	%rax, %rax
	movq	-80(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*result = t5*/
	movq	-88(%rbp), %rax
	movq	%rax, -72(%rbp)
/*t6 = 0*/
	movq	$0, %rax
	movq	%rax, -104(%rbp)
/*res = t6*/
	movq	-104(%rbp), %rax
	movq	%rax, -96(%rbp)
/*e0: skip*/
e0:
/*if left <= right goto e1*/
	movq	-24(%rbp), %rax
	movq	-40(%rbp), %rbx
	cmpq	%rbx, %rax
	ja 	1f
	jmp	e1
1:
/*t7 = 0*/
	movq	$0, %rax
	movq	%rax, -112(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t7 = -1*/
	movq	$-1, %rax
	movq	%rax, -112(%rbp)
/*e2: skip*/
e2:
/*t8 = not res*/
	movq	-96(%rbp), %rbx
	notq	%rbx
	movq	%rbx, -120(%rbp)
/*t9 = t7 and t8*/
	movq	-112(%rbp), %rax
	movq	-120(%rbp), %rbx
	andq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*if t9 = 0 goto e3*/
	movq	-128(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t10 = left + right*/
	movq	-24(%rbp), %rax
	movq	-40(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -144(%rbp)
/*t11 = 2*/
	movq	$2, %rax
	movq	%rax, -152(%rbp)
/*t12 = t10 / t11*/
	movq	-144(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	-152(%rbp), %rbx
	idivq	%rbx
	movq	%rax, -160(%rbp)
/*middle = t12*/
	movq	-160(%rbp), %rax
	movq	%rax, -136(%rbp)
/*t13 = middle + 1*/
	movq	-136(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -168(%rbp)
/*t13 = t13 * 8*/
	movq	-168(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -168(%rbp)
/*t14 = nums[t13]*/
	movq	16(%rbp), %rax
	movq	-168(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -176(%rbp)
/*if t14 = target goto e4*/
	movq	-176(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t15 = 0*/
	movq	$0, %rax
	movq	%rax, -184(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t15 = -1*/
	movq	$-1, %rax
	movq	%rax, -184(%rbp)
/*e5: skip*/
e5:
/*if t15 = 0 goto e6*/
	movq	-184(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*result = middle*/
	movq	-136(%rbp), %rax
	movq	%rax, -72(%rbp)
/*t16 = -1*/
	movq	$-1, %rax
	movq	%rax, -192(%rbp)
/*res = t16*/
	movq	-192(%rbp), %rax
	movq	%rax, -96(%rbp)
/*e6: skip*/
e6:
/*t17 = middle + 1*/
	movq	-136(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -200(%rbp)
/*t17 = t17 * 8*/
	movq	-200(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -200(%rbp)
/*t18 = nums[t17]*/
	movq	16(%rbp), %rax
	movq	-200(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -208(%rbp)
/*if target < t18 goto e7*/
	movq	24(%rbp), %rax
	movq	-208(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t19 = 0*/
	movq	$0, %rax
	movq	%rax, -216(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t19 = -1*/
	movq	$-1, %rax
	movq	%rax, -216(%rbp)
/*e8: skip*/
e8:
/*if t19 = 0 goto e9*/
	movq	-216(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e9
1:
/*t20 = 1*/
	movq	$1, %rax
	movq	%rax, -224(%rbp)
/*t21 = middle - t20*/
	movq	-136(%rbp), %rax
	movq	-224(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -232(%rbp)
/*right = t21*/
	movq	-232(%rbp), %rax
	movq	%rax, -40(%rbp)
/*goto e10*/
	jmp 	e10
/*e9: skip*/
e9:
/*t22 = 1*/
	movq	$1, %rax
	movq	%rax, -240(%rbp)
/*t23 = middle + t22*/
	movq	-136(%rbp), %rax
	movq	-240(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -248(%rbp)
/*left = t23*/
	movq	-248(%rbp), %rax
	movq	%rax, -24(%rbp)
/*e10: skip*/
e10:
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*rtn s0: result*/
	movq	-72(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$400, %rsp
/*t25 = 9*/
	movq	$9, %rax
	movq	%rax, -16(%rbp)
/*t26 = new array[7]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -24(%rbp)
/*t26[0] = 6*/
	movq	-24(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t27 = 1*/
	movq	$1, %rax
	movq	%rax, -32(%rbp)
/*t28 = - t27*/
	xorq 	%rax, %rax
	movq	-32(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t26[8] = t28*/
	movq	-24(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t29 = 0*/
	movq	$0, %rax
	movq	%rax, -48(%rbp)
/*t26[16] = t29*/
	movq	-24(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t30 = 3*/
	movq	$3, %rax
	movq	%rax, -56(%rbp)
/*t26[24] = t30*/
	movq	-24(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t31 = 5*/
	movq	$5, %rax
	movq	%rax, -64(%rbp)
/*t26[32] = t31*/
	movq	-24(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t32 = 9*/
	movq	$9, %rax
	movq	%rax, -72(%rbp)
/*t26[40] = t32*/
	movq	-24(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t33 = 12*/
	movq	$12, %rax
	movq	%rax, -80(%rbp)
/*t26[48] = t33*/
	movq	-24(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t25*/
	movq	-16(%rbp), %rax
	push	%rax
/*param_s t26*/
	movq	-24(%rbp), %rax
	push	%rax
/*t24 = call s0*/
	call	t_binarySearch
	movq	%rax, -8(%rbp)
/*printInt(t24)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t35 = 12*/
	movq	$12, %rax
	movq	%rax, -96(%rbp)
/*t36 = new array[7]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -104(%rbp)
/*t36[0] = 6*/
	movq	-104(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t37 = 1*/
	movq	$1, %rax
	movq	%rax, -112(%rbp)
/*t38 = - t37*/
	xorq 	%rax, %rax
	movq	-112(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t36[8] = t38*/
	movq	-104(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-120(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t39 = 0*/
	movq	$0, %rax
	movq	%rax, -128(%rbp)
/*t36[16] = t39*/
	movq	-104(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-128(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t40 = 3*/
	movq	$3, %rax
	movq	%rax, -136(%rbp)
/*t36[24] = t40*/
	movq	-104(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-136(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t41 = 5*/
	movq	$5, %rax
	movq	%rax, -144(%rbp)
/*t36[32] = t41*/
	movq	-104(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-144(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t42 = 9*/
	movq	$9, %rax
	movq	%rax, -152(%rbp)
/*t36[40] = t42*/
	movq	-104(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-152(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t43 = 12*/
	movq	$12, %rax
	movq	%rax, -160(%rbp)
/*t36[48] = t43*/
	movq	-104(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-160(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t35*/
	movq	-96(%rbp), %rax
	push	%rax
/*param_s t36*/
	movq	-104(%rbp), %rax
	push	%rax
/*t34 = call s0*/
	call	t_binarySearch
	movq	%rax, -88(%rbp)
/*printInt(t34)*/
	movq	-88(%rbp), %rdi
	call	print_uint64
/*t45 = 0*/
	movq	$0, %rax
	movq	%rax, -176(%rbp)
/*t46 = new array[7]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -184(%rbp)
/*t46[0] = 6*/
	movq	-184(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t47 = 1*/
	movq	$1, %rax
	movq	%rax, -192(%rbp)
/*t48 = - t47*/
	xorq 	%rax, %rax
	movq	-192(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -200(%rbp)
/*t46[8] = t48*/
	movq	-184(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-200(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t49 = 0*/
	movq	$0, %rax
	movq	%rax, -208(%rbp)
/*t46[16] = t49*/
	movq	-184(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-208(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t50 = 3*/
	movq	$3, %rax
	movq	%rax, -216(%rbp)
/*t46[24] = t50*/
	movq	-184(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-216(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t51 = 5*/
	movq	$5, %rax
	movq	%rax, -224(%rbp)
/*t46[32] = t51*/
	movq	-184(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-224(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t52 = 9*/
	movq	$9, %rax
	movq	%rax, -232(%rbp)
/*t46[40] = t52*/
	movq	-184(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-232(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t53 = 12*/
	movq	$12, %rax
	movq	%rax, -240(%rbp)
/*t46[48] = t53*/
	movq	-184(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-240(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t45*/
	movq	-176(%rbp), %rax
	push	%rax
/*param_s t46*/
	movq	-184(%rbp), %rax
	push	%rax
/*t44 = call s0*/
	call	t_binarySearch
	movq	%rax, -168(%rbp)
/*printInt(t44)*/
	movq	-168(%rbp), %rdi
	call	print_uint64
/*t55 = 5*/
	movq	$5, %rax
	movq	%rax, -256(%rbp)
/*t56 = new array[7]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -264(%rbp)
/*t56[0] = 6*/
	movq	-264(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t57 = 1*/
	movq	$1, %rax
	movq	%rax, -272(%rbp)
/*t58 = - t57*/
	xorq 	%rax, %rax
	movq	-272(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -280(%rbp)
/*t56[8] = t58*/
	movq	-264(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-280(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t59 = 0*/
	movq	$0, %rax
	movq	%rax, -288(%rbp)
/*t56[16] = t59*/
	movq	-264(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-288(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t60 = 3*/
	movq	$3, %rax
	movq	%rax, -296(%rbp)
/*t56[24] = t60*/
	movq	-264(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-296(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t61 = 5*/
	movq	$5, %rax
	movq	%rax, -304(%rbp)
/*t56[32] = t61*/
	movq	-264(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-304(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t62 = 9*/
	movq	$9, %rax
	movq	%rax, -312(%rbp)
/*t56[40] = t62*/
	movq	-264(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-312(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t63 = 12*/
	movq	$12, %rax
	movq	%rax, -320(%rbp)
/*t56[48] = t63*/
	movq	-264(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-320(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t55*/
	movq	-256(%rbp), %rax
	push	%rax
/*param_s t56*/
	movq	-264(%rbp), %rax
	push	%rax
/*t54 = call s0*/
	call	t_binarySearch
	movq	%rax, -248(%rbp)
/*printInt(t54)*/
	movq	-248(%rbp), %rdi
	call	print_uint64
/*t65 = 7*/
	movq	$7, %rax
	movq	%rax, -336(%rbp)
/*t66 = new array[7]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -344(%rbp)
/*t66[0] = 6*/
	movq	-344(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t67 = 1*/
	movq	$1, %rax
	movq	%rax, -352(%rbp)
/*t68 = - t67*/
	xorq 	%rax, %rax
	movq	-352(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -360(%rbp)
/*t66[8] = t68*/
	movq	-344(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-360(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t69 = 0*/
	movq	$0, %rax
	movq	%rax, -368(%rbp)
/*t66[16] = t69*/
	movq	-344(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-368(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t70 = 3*/
	movq	$3, %rax
	movq	%rax, -376(%rbp)
/*t66[24] = t70*/
	movq	-344(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-376(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t71 = 5*/
	movq	$5, %rax
	movq	%rax, -384(%rbp)
/*t66[32] = t71*/
	movq	-344(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-384(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t72 = 9*/
	movq	$9, %rax
	movq	%rax, -392(%rbp)
/*t66[40] = t72*/
	movq	-344(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-392(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t73 = 12*/
	movq	$12, %rax
	movq	%rax, -400(%rbp)
/*t66[48] = t73*/
	movq	-344(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-400(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t65*/
	movq	-336(%rbp), %rax
	push	%rax
/*param_s t66*/
	movq	-344(%rbp), %rax
	push	%rax
/*t64 = call s0*/
	call	t_binarySearch
	movq	%rax, -328(%rbp)
/*printInt(t64)*/
	movq	-328(%rbp), %rdi
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
	arr_3: .fill 7, 8
	arr_4: .fill 7, 8
	arr_5: .fill 7, 8
	arr_6: .fill 7, 8
	arr_7: .fill 7, 8
