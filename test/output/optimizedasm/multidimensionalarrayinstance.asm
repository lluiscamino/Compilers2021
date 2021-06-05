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
	subq	$402, %rsp
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
	movb	$0, %al
	movb	%al, -81(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t10 = -1*/
	movb	$-1, %al
	movb	%al, -81(%rbp)
/*e4: skip*/
e4:
/*if t10 = 0 goto e5*/
	movb	-81(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e5
1:
/*j = 0*/
	movq	$0, %rax
	movq	%rax, -89(%rbp)
/*e6: skip*/
e6:
/*if j < 100 goto e7*/
	movq	-89(%rbp), %rax
	movq	$100, %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t13 = 0*/
	movb	$0, %al
	movb	%al, -90(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t13 = -1*/
	movb	$-1, %al
	movb	%al, -90(%rbp)
/*e8: skip*/
e8:
/*if t13 = 0 goto e9*/
	movb	-90(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e9
1:
/*t14 = input*/
	movq	-8(%rbp), %rax
	movq	%rax, -98(%rbp)
/*t15 = i * 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -106(%rbp)
/*t15 = t15 + 8*/
	movq	-106(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -106(%rbp)
/*t14 = t14[t15]*/
	movq	-98(%rbp), %rax
	movq	-106(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -98(%rbp)
/*t16 = i * j*/
	movq	-80(%rbp), %rax
	movq	-89(%rbp), %rbx
	imulq	%rbx, %rax
	movq	%rax, -114(%rbp)
/*t15 = j * 8*/
	movq	-89(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -106(%rbp)
/*t15 = t15 + 8*/
	movq	-106(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -106(%rbp)
/*t14[t15] = t16*/
	movq	-98(%rbp), %rcx
	movq	-106(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-114(%rbp), %rbx
	movq	%rbx, (%rcx)
/*j = j + 1*/
	movq	-89(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -89(%rbp)
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
	movq	%rax, -122(%rbp)
/*t20 = t20 + 8*/
	movq	-122(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -122(%rbp)
/*t21 = input[t20]*/
	movq	-8(%rbp), %rax
	movq	-122(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -130(%rbp)
/*t23 = 40*/
	movq	$40, %rax
	movq	%rax, -138(%rbp)
/*t23 = t23 + 8*/
	movq	-138(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -138(%rbp)
/*t24 = t21[t23]*/
	movq	-130(%rbp), %rax
	movq	-138(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -146(%rbp)
/*printInt(t24)*/
	movq	-146(%rbp), %rdi
	call	print_uint64
/*t26 = 200*/
	movq	$200, %rax
	movq	%rax, -154(%rbp)
/*t26 = t26 + 8*/
	movq	-154(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -154(%rbp)
/*t27 = input[t26]*/
	movq	-8(%rbp), %rax
	movq	-154(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -162(%rbp)
/*t29 = 72*/
	movq	$72, %rax
	movq	%rax, -170(%rbp)
/*t29 = t29 + 8*/
	movq	-170(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -170(%rbp)
/*t30 = t27[t29]*/
	movq	-162(%rbp), %rax
	movq	-170(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -178(%rbp)
/*printInt(t30)*/
	movq	-178(%rbp), %rdi
	call	print_uint64
/*t32 = 624*/
	movq	$624, %rax
	movq	%rax, -186(%rbp)
/*t32 = t32 + 8*/
	movq	-186(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -186(%rbp)
/*t33 = input[t32]*/
	movq	-8(%rbp), %rax
	movq	-186(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -194(%rbp)
/*t35 = 256*/
	movq	$256, %rax
	movq	%rax, -202(%rbp)
/*t35 = t35 + 8*/
	movq	-202(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -202(%rbp)
/*t36 = t33[t35]*/
	movq	-194(%rbp), %rax
	movq	-202(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -210(%rbp)
/*printInt(t36)*/
	movq	-210(%rbp), %rdi
	call	print_uint64
/*t38 = 336*/
	movq	$336, %rax
	movq	%rax, -218(%rbp)
/*t38 = t38 + 8*/
	movq	-218(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -218(%rbp)
/*t39 = input[t38]*/
	movq	-8(%rbp), %rax
	movq	-218(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -226(%rbp)
/*t41 = 608*/
	movq	$608, %rax
	movq	%rax, -234(%rbp)
/*t41 = t41 + 8*/
	movq	-234(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -234(%rbp)
/*t42 = t39[t41]*/
	movq	-226(%rbp), %rax
	movq	-234(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -242(%rbp)
/*printInt(t42)*/
	movq	-242(%rbp), %rdi
	call	print_uint64
/*t44 = 24*/
	movq	$24, %rax
	movq	%rax, -250(%rbp)
/*t44 = t44 + 8*/
	movq	-250(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -250(%rbp)
/*t45 = input[t44]*/
	movq	-8(%rbp), %rax
	movq	-250(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -258(%rbp)
/*t47 = 536*/
	movq	$536, %rax
	movq	%rax, -266(%rbp)
/*t47 = t47 + 8*/
	movq	-266(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -266(%rbp)
/*t48 = t45[t47]*/
	movq	-258(%rbp), %rax
	movq	-266(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -274(%rbp)
/*printInt(t48)*/
	movq	-274(%rbp), %rdi
	call	print_uint64
/*t50 = 64*/
	movq	$64, %rax
	movq	%rax, -282(%rbp)
/*t50 = t50 + 8*/
	movq	-282(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -282(%rbp)
/*t51 = input[t50]*/
	movq	-8(%rbp), %rax
	movq	-282(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -290(%rbp)
/*t53 = 432*/
	movq	$432, %rax
	movq	%rax, -298(%rbp)
/*t53 = t53 + 8*/
	movq	-298(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -298(%rbp)
/*t54 = t51[t53]*/
	movq	-290(%rbp), %rax
	movq	-298(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -306(%rbp)
/*printInt(t54)*/
	movq	-306(%rbp), %rdi
	call	print_uint64
/*t56 = 776*/
	movq	$776, %rax
	movq	%rax, -314(%rbp)
/*t56 = t56 + 8*/
	movq	-314(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -314(%rbp)
/*t57 = input[t56]*/
	movq	-8(%rbp), %rax
	movq	-314(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -322(%rbp)
/*t59 = 96*/
	movq	$96, %rax
	movq	%rax, -330(%rbp)
/*t59 = t59 + 8*/
	movq	-330(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -330(%rbp)
/*t60 = t57[t59]*/
	movq	-322(%rbp), %rax
	movq	-330(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -338(%rbp)
/*printInt(t60)*/
	movq	-338(%rbp), %rdi
	call	print_uint64
/*t62 = 96*/
	movq	$96, %rax
	movq	%rax, -346(%rbp)
/*t62 = t62 + 8*/
	movq	-346(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -346(%rbp)
/*t63 = input[t62]*/
	movq	-8(%rbp), %rax
	movq	-346(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -354(%rbp)
/*t65 = 272*/
	movq	$272, %rax
	movq	%rax, -362(%rbp)
/*t65 = t65 + 8*/
	movq	-362(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -362(%rbp)
/*t66 = t63[t65]*/
	movq	-354(%rbp), %rax
	movq	-362(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -370(%rbp)
/*printInt(t66)*/
	movq	-370(%rbp), %rdi
	call	print_uint64
/*t68 = 184*/
	movq	$184, %rax
	movq	%rax, -378(%rbp)
/*t68 = t68 + 8*/
	movq	-378(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -378(%rbp)
/*t69 = input[t68]*/
	movq	-8(%rbp), %rax
	movq	-378(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -386(%rbp)
/*t71 = 256*/
	movq	$256, %rax
	movq	%rax, -394(%rbp)
/*t71 = t71 + 8*/
	movq	-394(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -394(%rbp)
/*t72 = t69[t71]*/
	movq	-386(%rbp), %rax
	movq	-394(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -402(%rbp)
/*printInt(t72)*/
	movq	-402(%rbp), %rdi
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
