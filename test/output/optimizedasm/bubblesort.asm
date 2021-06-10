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
/*t_bubbleSort: skip*/
t_bubbleSort:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$83, %rsp
/*changes = -1*/
	movb	$-1, %al
	movb	%al, -9(%rbp)
/*e0: skip*/
e0:
/*if changes = 0 goto e1*/
	movb	-9(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e1
1:
/*changes = 0*/
	movb	$0, %al
	movb	%al, -9(%rbp)
/*i = 0*/
	movq	$0, %rax
	movq	%rax, -17(%rbp)
/*e2: skip*/
e2:
/*t3 = values[0]*/
	movq	16(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -25(%rbp)
/*t5 = t3 - 1*/
	movq	-25(%rbp), %rax
	movq	$1, %rbx
	subq	%rbx, %rax
	movq	%rax, -33(%rbp)
/*if i < t5 goto e3*/
	movq	-17(%rbp), %rax
	movq	-33(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e3
1:
/*t6 = 0*/
	movb	$0, %al
	movb	%al, -34(%rbp)
/*goto e4*/
	jmp 	e4
/*e3: skip*/
e3:
/*t6 = -1*/
	movb	$-1, %al
	movb	%al, -34(%rbp)
/*e4: skip*/
e4:
/*if t6 = 0 goto e0*/
	movb	-34(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e0
1:
/*t7 = i * 8*/
	movq	-17(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -42(%rbp)
/*t7 = t7 + 8*/
	movq	-42(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -42(%rbp)
/*t8 = values[t7]*/
	movq	16(%rbp), %rax
	movq	-42(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -50(%rbp)
/*t10 = i + 1*/
	movq	-17(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -58(%rbp)
/*t11 = t10 * 8*/
	movq	-58(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -66(%rbp)
/*t11 = t11 + 8*/
	movq	-66(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -66(%rbp)
/*t12 = values[t11]*/
	movq	16(%rbp), %rax
	movq	-66(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -74(%rbp)
/*if t8 > t12 goto e6*/
	movq	-50(%rbp), %rax
	movq	-74(%rbp), %rbx
	cmpq	%rbx, %rax
	jle 	1f
	jmp	e6
1:
/*t13 = 0*/
	movb	$0, %al
	movb	%al, -75(%rbp)
/*goto e7*/
	jmp 	e7
/*e6: skip*/
e6:
/*t13 = -1*/
	movb	$-1, %al
	movb	%al, -75(%rbp)
/*e7: skip*/
e7:
/*if t13 = 0 goto e8*/
	movb	-75(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e8
1:
/*t15 = i + 1*/
	movq	-17(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -83(%rbp)
/*param t15*/
	movq	-83(%rbp), %rax
	push	%rax
/*param i*/
	movq	-17(%rbp), %rax
	push	%rax
/*param values*/
	movq	16(%rbp), %rax
	push	%rax
/*call s1*/
	call	t_swap
/*changes = -1*/
	movb	$-1, %al
	movb	%al, -9(%rbp)
/*e8: skip*/
e8:
/*i = i + 1*/
	movq	-17(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -17(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_swap: skip*/
t_swap:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$80, %rsp
/*t18 = i * 8*/
	movq	24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t18 = t18 + 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t19 = values[t18]*/
	movq	16(%rbp), %rax
	movq	-40(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
/*temp = t19*/
	movq	-48(%rbp), %rax
	movq	%rax, -32(%rbp)
/*t22 = j * 8*/
	movq	32(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t22 = t22 + 8*/
	movq	-64(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t23 = values[t22]*/
	movq	16(%rbp), %rax
	movq	-64(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -72(%rbp)
/*t21 = i * 8*/
	movq	24(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*t21 = t21 + 8*/
	movq	-56(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*values[t21] = t23*/
	movq	16(%rbp), %rcx
	movq	-56(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t25 = j * 8*/
	movq	32(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*t25 = t25 + 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*values[t25] = temp*/
	movq	16(%rbp), %rcx
	movq	-80(%rbp), %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*rtn s1*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_printArray: skip*/
t_printArray:
/*pmb s2*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$40, %rsp
/*t26 = 0*/
	movq	$0, %rax
	movq	%rax, -16(%rbp)
/*t28 = values[0]*/
	movq	16(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -32(%rbp)
/*value = 0*/
	movq	$0, %rax
	movq	%rax, -40(%rbp)
/*e9: skip*/
e9:
/*if t26 = t28 goto e10*/
	movq	-16(%rbp), %rax
	movq	-32(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e10
1:
/*t27 = t26 * 8*/
	movq	-16(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*t27 = t27 + 8*/
	movq	-24(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*value = values[t27]*/
	movq	16(%rbp), %rax
	movq	-24(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*printInt(value)*/
	movq	-40(%rbp), %rdi
	call	print_uint64
/*t26 = t26 + 1*/
	movq	-16(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*goto e9*/
	jmp 	e9
/*e10: skip*/
e10:
/*rtn s2*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s3*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$16, %rsp
/*t30 = new array[10]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t30[0] = 10*/
	movq	-16(%rbp), %rcx
	movq	$10, %rbx
	movq	%rbx, (%rcx)
/*t30[8] = 8*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*t30[16] = 3*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t30[24] = 4*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t30[32] = 5*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t30[40] = 7*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$7, %rbx
	movq	%rbx, (%rcx)
/*t30[48] = 2*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t30[56] = 0*/
	movq	-16(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t30[64] = 6*/
	movq	-16(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t30[72] = 1*/
	movq	-16(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t30[80] = 9*/
	movq	-16(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*values = t30*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*param values*/
	movq	-8(%rbp), %rax
	push	%rax
/*call s0*/
	call	t_bubbleSort
/*param values*/
	movq	-8(%rbp), %rax
	push	%rax
/*call s2*/
	call	t_printArray
/*rtn s3*/
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
	arr_3: .fill 88, 1
