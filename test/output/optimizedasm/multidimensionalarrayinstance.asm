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
	subq	$416, %rsp
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
/*i = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*e2: skip*/
e2:
/*if i < 100 goto e3*/
	movq	-80(%rbp), %rax
	movq	$100, %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e3
1:
/*t10 = 0*/
	movq	$0, %rax
	movq	%rax, -88(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t10 = -1*/
	movq	$-1, %rax
	movq	%rax, -88(%rbp)
/*e4: skip*/
e4:
/*if t10 = 0 goto e5*/
	movq	-88(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e5
1:
/*j = 0*/
	movq	$0, %rax
	movq	%rax, -96(%rbp)
/*e6: skip*/
e6:
/*if j < 100 goto e7*/
	movq	-96(%rbp), %rax
	movq	$100, %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t13 = 0*/
	movq	$0, %rax
	movq	%rax, -104(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t13 = -1*/
	movq	$-1, %rax
	movq	%rax, -104(%rbp)
/*e8: skip*/
e8:
/*if t13 = 0 goto e9*/
	movq	-104(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e9
1:
/*t14 = input*/
	movq	-8(%rbp), %rax
	movq	%rax, -112(%rbp)
/*t15 = i * 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t15 = t15 + 8*/
	movq	-120(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t14 = t14[t15]*/
	movq	-112(%rbp), %rax
	movq	-120(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -112(%rbp)
/*t16 = i * j*/
	movq	-80(%rbp), %rax
	movq	-96(%rbp), %rbx
	imulq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t15 = j * 8*/
	movq	-96(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t15 = t15 + 8*/
	movq	-120(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -120(%rbp)
/*t14[t15] = t16*/
	movq	-112(%rbp), %rcx
	movq	-120(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-128(%rbp), %rbx
	movq	%rbx, (%rcx)
/*j = j + 1*/
	movq	-96(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*goto e6*/
	jmp 	e6
/*e9: skip*/
e9:
/*i = i + 1*/
	movq	-80(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*goto e2*/
	jmp 	e2
/*e5: skip*/
e5:
/*t20 = 16*/
	movq	$16, %rax
	movq	%rax, -136(%rbp)
/*t20 = t20 + 8*/
	movq	-136(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -136(%rbp)
/*t21 = input[t20]*/
	movq	-8(%rbp), %rax
	movq	-136(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -144(%rbp)
/*t23 = 40*/
	movq	$40, %rax
	movq	%rax, -152(%rbp)
/*t23 = t23 + 8*/
	movq	-152(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t24 = t21[t23]*/
	movq	-144(%rbp), %rax
	movq	-152(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -160(%rbp)
/*printInt(t24)*/
	movq	-160(%rbp), %rdi
	call	print_uint64
/*t26 = 200*/
	movq	$200, %rax
	movq	%rax, -168(%rbp)
/*t26 = t26 + 8*/
	movq	-168(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -168(%rbp)
/*t27 = input[t26]*/
	movq	-8(%rbp), %rax
	movq	-168(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -176(%rbp)
/*t29 = 72*/
	movq	$72, %rax
	movq	%rax, -184(%rbp)
/*t29 = t29 + 8*/
	movq	-184(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -184(%rbp)
/*t30 = t27[t29]*/
	movq	-176(%rbp), %rax
	movq	-184(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -192(%rbp)
/*printInt(t30)*/
	movq	-192(%rbp), %rdi
	call	print_uint64
/*t32 = 624*/
	movq	$624, %rax
	movq	%rax, -200(%rbp)
/*t32 = t32 + 8*/
	movq	-200(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -200(%rbp)
/*t33 = input[t32]*/
	movq	-8(%rbp), %rax
	movq	-200(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -208(%rbp)
/*t35 = 256*/
	movq	$256, %rax
	movq	%rax, -216(%rbp)
/*t35 = t35 + 8*/
	movq	-216(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -216(%rbp)
/*t36 = t33[t35]*/
	movq	-208(%rbp), %rax
	movq	-216(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -224(%rbp)
/*printInt(t36)*/
	movq	-224(%rbp), %rdi
	call	print_uint64
/*t38 = 336*/
	movq	$336, %rax
	movq	%rax, -232(%rbp)
/*t38 = t38 + 8*/
	movq	-232(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -232(%rbp)
/*t39 = input[t38]*/
	movq	-8(%rbp), %rax
	movq	-232(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -240(%rbp)
/*t41 = 608*/
	movq	$608, %rax
	movq	%rax, -248(%rbp)
/*t41 = t41 + 8*/
	movq	-248(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -248(%rbp)
/*t42 = t39[t41]*/
	movq	-240(%rbp), %rax
	movq	-248(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -256(%rbp)
/*printInt(t42)*/
	movq	-256(%rbp), %rdi
	call	print_uint64
/*t44 = 24*/
	movq	$24, %rax
	movq	%rax, -264(%rbp)
/*t44 = t44 + 8*/
	movq	-264(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -264(%rbp)
/*t45 = input[t44]*/
	movq	-8(%rbp), %rax
	movq	-264(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -272(%rbp)
/*t47 = 536*/
	movq	$536, %rax
	movq	%rax, -280(%rbp)
/*t47 = t47 + 8*/
	movq	-280(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -280(%rbp)
/*t48 = t45[t47]*/
	movq	-272(%rbp), %rax
	movq	-280(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -288(%rbp)
/*printInt(t48)*/
	movq	-288(%rbp), %rdi
	call	print_uint64
/*t50 = 64*/
	movq	$64, %rax
	movq	%rax, -296(%rbp)
/*t50 = t50 + 8*/
	movq	-296(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -296(%rbp)
/*t51 = input[t50]*/
	movq	-8(%rbp), %rax
	movq	-296(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -304(%rbp)
/*t53 = 432*/
	movq	$432, %rax
	movq	%rax, -312(%rbp)
/*t53 = t53 + 8*/
	movq	-312(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -312(%rbp)
/*t54 = t51[t53]*/
	movq	-304(%rbp), %rax
	movq	-312(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -320(%rbp)
/*printInt(t54)*/
	movq	-320(%rbp), %rdi
	call	print_uint64
/*t56 = 776*/
	movq	$776, %rax
	movq	%rax, -328(%rbp)
/*t56 = t56 + 8*/
	movq	-328(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -328(%rbp)
/*t57 = input[t56]*/
	movq	-8(%rbp), %rax
	movq	-328(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -336(%rbp)
/*t59 = 96*/
	movq	$96, %rax
	movq	%rax, -344(%rbp)
/*t59 = t59 + 8*/
	movq	-344(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -344(%rbp)
/*t60 = t57[t59]*/
	movq	-336(%rbp), %rax
	movq	-344(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -352(%rbp)
/*printInt(t60)*/
	movq	-352(%rbp), %rdi
	call	print_uint64
/*t62 = 96*/
	movq	$96, %rax
	movq	%rax, -360(%rbp)
/*t62 = t62 + 8*/
	movq	-360(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -360(%rbp)
/*t63 = input[t62]*/
	movq	-8(%rbp), %rax
	movq	-360(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -368(%rbp)
/*t65 = 272*/
	movq	$272, %rax
	movq	%rax, -376(%rbp)
/*t65 = t65 + 8*/
	movq	-376(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -376(%rbp)
/*t66 = t63[t65]*/
	movq	-368(%rbp), %rax
	movq	-376(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -384(%rbp)
/*printInt(t66)*/
	movq	-384(%rbp), %rdi
	call	print_uint64
/*t68 = 184*/
	movq	$184, %rax
	movq	%rax, -392(%rbp)
/*t68 = t68 + 8*/
	movq	-392(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -392(%rbp)
/*t69 = input[t68]*/
	movq	-8(%rbp), %rax
	movq	-392(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -400(%rbp)
/*t71 = 256*/
	movq	$256, %rax
	movq	%rax, -408(%rbp)
/*t71 = t71 + 8*/
	movq	-408(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -408(%rbp)
/*t72 = t69[t71]*/
	movq	-400(%rbp), %rax
	movq	-408(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -416(%rbp)
/*printInt(t72)*/
	movq	-416(%rbp), %rdi
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
