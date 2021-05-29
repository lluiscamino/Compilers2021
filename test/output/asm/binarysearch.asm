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
/*t_binarySearch: skip*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
t_binarySearch:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$184, %rsp
/*left = 0*/
	movq	$0, %rax
	movq	%rax, -24(%rbp)
/*t1 = nums[0]*/
	movq	16(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*t3 = t1 - 1*/
	movq	-40(%rbp), %rax
	movq	$1, %rbx
	subq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*right = t3*/
	movq	-48(%rbp), %rax
	movq	%rax, -32(%rbp)
/*t5 = -1*/
	movq	$-1, %rax
	movq	%rax, -64(%rbp)
/*result = t5*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*res = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*e0: skip*/
e0:
/*if left <= right goto e1*/
	movq	-24(%rbp), %rax
	movq	-32(%rbp), %rbx
	cmpq	%rbx, %rax
	ja 	1f
	jmp	e1
1:
/*t7 = 0*/
	movq	$0, %rax
	movq	%rax, -80(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t7 = -1*/
	movq	$-1, %rax
	movq	%rax, -80(%rbp)
/*e2: skip*/
e2:
/*t8 = not res*/
	movq	-72(%rbp), %rbx
	notq	%rbx
	movq	%rbx, -88(%rbp)
/*t9 = t7 and t8*/
	movq	-80(%rbp), %rax
	movq	-88(%rbp), %rbx
	andq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*if t9 = 0 goto e3*/
	movq	-96(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t10 = left + right*/
	movq	-24(%rbp), %rax
	movq	-32(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*t12 = t10 / 2*/
	movq	-112(%rbp), %rax
	movq	%rax, %rdx
	sarq	$31, %rdx
	movq	$2, %rbx
	idivq	%rbx
	movq	%rax, -120(%rbp)
/*middle = t12*/
	movq	-120(%rbp), %rax
	movq	%rax, -104(%rbp)
/*t13 = middle + 1*/
	movq	-104(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t13 = t13 * 8*/
	movq	-128(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t14 = nums[t13]*/
	movq	16(%rbp), %rax
	movq	-128(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -136(%rbp)
/*if t14 = target goto e4*/
	movq	-136(%rbp), %rax
	movq	24(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e4
1:
/*t15 = 0*/
	movq	$0, %rax
	movq	%rax, -144(%rbp)
/*goto e5*/
	jmp 	e5
/*e4: skip*/
e4:
/*t15 = -1*/
	movq	$-1, %rax
	movq	%rax, -144(%rbp)
/*e5: skip*/
e5:
/*if t15 = 0 goto e6*/
	movq	-144(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e6
1:
/*result = middle*/
	movq	-104(%rbp), %rax
	movq	%rax, -56(%rbp)
/*res = -1*/
	movq	$-1, %rax
	movq	%rax, -72(%rbp)
/*e6: skip*/
e6:
/*t17 = middle + 1*/
	movq	-104(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t17 = t17 * 8*/
	movq	-152(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*t18 = nums[t17]*/
	movq	16(%rbp), %rax
	movq	-152(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -160(%rbp)
/*if target < t18 goto e7*/
	movq	24(%rbp), %rax
	movq	-160(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e7
1:
/*t19 = 0*/
	movq	$0, %rax
	movq	%rax, -168(%rbp)
/*goto e8*/
	jmp 	e8
/*e7: skip*/
e7:
/*t19 = -1*/
	movq	$-1, %rax
	movq	%rax, -168(%rbp)
/*e8: skip*/
e8:
/*if t19 = 0 goto e9*/
	movq	-168(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e9
1:
/*t21 = middle - 1*/
	movq	-104(%rbp), %rax
	movq	$1, %rbx
	subq	%rbx, %rax
	movq	%rax, -176(%rbp)
/*right = t21*/
	movq	-176(%rbp), %rax
	movq	%rax, -32(%rbp)
/*goto e10*/
	jmp 	e10
/*e9: skip*/
e9:
/*t23 = middle + 1*/
	movq	-104(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -184(%rbp)
/*left = t23*/
	movq	-184(%rbp), %rax
	movq	%rax, -24(%rbp)
/*e10: skip*/
e10:
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*rtn s0: result*/
	movq	-56(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$120, %rsp
/*t26 = new array[7]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t26[0] = 6*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t28 = -1*/
	movq	$-1, %rax
	movq	%rax, -24(%rbp)
/*t26[8] = t28*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t26[16] = 0*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t26[24] = 3*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t26[32] = 5*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t26[40] = 9*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t26[48] = 12*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$12, %rbx
	movq	%rbx, (%rcx)
/*param_s 9*/
	movq	$9, %rax
	push	%rax
/*param_s t26*/
	movq	-16(%rbp), %rax
	push	%rax
/*t24 = call s0*/
	call	t_binarySearch
	movq	%rax, -8(%rbp)
/*printInt(t24)*/
	movq	-8(%rbp), %rdi
	call	print_uint64
/*t36 = new array[7]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -40(%rbp)
/*t36[0] = 6*/
	movq	-40(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t38 = -1*/
	movq	$-1, %rax
	movq	%rax, -48(%rbp)
/*t36[8] = t38*/
	movq	-40(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t36[16] = 0*/
	movq	-40(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t36[24] = 3*/
	movq	-40(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t36[32] = 5*/
	movq	-40(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t36[40] = 9*/
	movq	-40(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t36[48] = 12*/
	movq	-40(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$12, %rbx
	movq	%rbx, (%rcx)
/*param_s 12*/
	movq	$12, %rax
	push	%rax
/*param_s t36*/
	movq	-40(%rbp), %rax
	push	%rax
/*t34 = call s0*/
	call	t_binarySearch
	movq	%rax, -32(%rbp)
/*printInt(t34)*/
	movq	-32(%rbp), %rdi
	call	print_uint64
/*t46 = new array[7]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -64(%rbp)
/*t46[0] = 6*/
	movq	-64(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t48 = -1*/
	movq	$-1, %rax
	movq	%rax, -72(%rbp)
/*t46[8] = t48*/
	movq	-64(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t46[16] = 0*/
	movq	-64(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t46[24] = 3*/
	movq	-64(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t46[32] = 5*/
	movq	-64(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t46[40] = 9*/
	movq	-64(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t46[48] = 12*/
	movq	-64(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$12, %rbx
	movq	%rbx, (%rcx)
/*param_s 0*/
	movq	$0, %rax
	push	%rax
/*param_s t46*/
	movq	-64(%rbp), %rax
	push	%rax
/*t44 = call s0*/
	call	t_binarySearch
	movq	%rax, -56(%rbp)
/*printInt(t44)*/
	movq	-56(%rbp), %rdi
	call	print_uint64
/*t56 = new array[7]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -88(%rbp)
/*t56[0] = 6*/
	movq	-88(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t58 = -1*/
	movq	$-1, %rax
	movq	%rax, -96(%rbp)
/*t56[8] = t58*/
	movq	-88(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-96(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t56[16] = 0*/
	movq	-88(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t56[24] = 3*/
	movq	-88(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t56[32] = 5*/
	movq	-88(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t56[40] = 9*/
	movq	-88(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t56[48] = 12*/
	movq	-88(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$12, %rbx
	movq	%rbx, (%rcx)
/*param_s 5*/
	movq	$5, %rax
	push	%rax
/*param_s t56*/
	movq	-88(%rbp), %rax
	push	%rax
/*t54 = call s0*/
	call	t_binarySearch
	movq	%rax, -80(%rbp)
/*printInt(t54)*/
	movq	-80(%rbp), %rdi
	call	print_uint64
/*t66 = new array[7]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -112(%rbp)
/*t66[0] = 6*/
	movq	-112(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t68 = -1*/
	movq	$-1, %rax
	movq	%rax, -120(%rbp)
/*t66[8] = t68*/
	movq	-112(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-120(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t66[16] = 0*/
	movq	-112(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t66[24] = 3*/
	movq	-112(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t66[32] = 5*/
	movq	-112(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t66[40] = 9*/
	movq	-112(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t66[48] = 12*/
	movq	-112(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$12, %rbx
	movq	%rbx, (%rcx)
/*param_s 7*/
	movq	$7, %rax
	push	%rax
/*param_s t66*/
	movq	-112(%rbp), %rax
	push	%rax
/*t64 = call s0*/
	call	t_binarySearch
	movq	%rax, -104(%rbp)
/*printInt(t64)*/
	movq	-104(%rbp), %rdi
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
