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
/*t_average: skip*/
t_average:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$80, %rsp
/*t0 = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*sum = t0*/
	movq	-24(%rbp), %rax
	movq	%rax, -16(%rbp)
/*t1 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*t3 = nums[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*t4 = 0*/
	movq	$0, %rax
	movq	%rax, -64(%rbp)
/*num = t4*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*e0: skip*/
e0:
/*if t1 = t3 goto e1*/
	movq	-32(%rbp), %rax
	movq	-48(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t2 = t1 + 1*/
	movq	-32(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t2 = t2 * 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*num = nums[t2]*/
	movq	16(%rbp), %rax
	movq	-40(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -56(%rbp)
/*sum = sum + num*/
	movq	-16(%rbp), %rax
	movq	-56(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*t1 = t1 + 1*/
	movq	-32(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*goto e0*/
	jmp 	e0
/*e1: skip*/
e1:
/*t5 = nums[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -72(%rbp)
/*t6 = sum / t5*/
	movq	-16(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	-72(%rbp), %rbx
	idivq	%rbx
	movq	%rax, -80(%rbp)
/*rtn s0: t6*/
	movq	-80(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$64, %rsp
/*t8 = new array[7]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t8[0] = 6*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t9 = 10*/
	movq	$10, %rax
	movq	%rax, -24(%rbp)
/*t8[8] = t9*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t10 = 5*/
	movq	$5, %rax
	movq	%rax, -32(%rbp)
/*t8[16] = t10*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t11 = 7*/
	movq	$7, %rax
	movq	%rax, -40(%rbp)
/*t8[24] = t11*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t12 = 4*/
	movq	$4, %rax
	movq	%rax, -48(%rbp)
/*t8[32] = t12*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t13 = 3*/
	movq	$3, %rax
	movq	%rax, -56(%rbp)
/*t8[40] = t13*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t14 = 7*/
	movq	$7, %rax
	movq	%rax, -64(%rbp)
/*t8[48] = t14*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*param_s t8*/
	movq	-16(%rbp), %rax
	push	%rax
/*t7 = call s0*/
	call	t_average
	movq	%rax, -8(%rbp)
/*printInt(t7)*/
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
	arr_3: .fill 7, 8
