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
	subq	$183, %rsp
/*t0 = new array[4]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 4*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t1 = 3*/
	movq	$3, %rax
	movq	%rax, -24(%rbp)
/*t0[8] = t1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t2 = 8*/
	movq	$8, %rax
	movq	%rax, -32(%rbp)
/*t0[16] = t2*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t3 = 24*/
	movq	$24, %rax
	movq	%rax, -40(%rbp)
/*t0[24] = t3*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4 = 9*/
	movq	$9, %rax
	movq	%rax, -48(%rbp)
/*t0[32] = t4*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*intArray = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t5 = new array[4]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -64(%rbp)
/*t5[0] = 4*/
	movq	-64(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t6 = -1*/
	movb	$-1, %al
	movb	%al, -65(%rbp)
/*t5[8] = t6*/
	movq	-64(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movb	-65(%rbp), %bl
	movb	%bl, (%rcx)
/*t7 = 0*/
	movb	$0, %al
	movb	%al, -66(%rbp)
/*t5[9] = t7*/
	movq	-64(%rbp), %rcx
	movq	$9, %rbx
	addq	%rbx, %rcx
	movb	-66(%rbp), %bl
	movb	%bl, (%rcx)
/*t8 = -1*/
	movb	$-1, %al
	movb	%al, -67(%rbp)
/*t9 = not t8*/
	movb	-67(%rbp), %bl
	notb	%bl
	movb	%bl, -68(%rbp)
/*t5[10] = t9*/
	movq	-64(%rbp), %rcx
	movq	$10, %rbx
	addq	%rbx, %rcx
	movb	-68(%rbp), %bl
	movb	%bl, (%rcx)
/*t10 = 0*/
	movb	$0, %al
	movb	%al, -69(%rbp)
/*t11 = not t10*/
	movb	-69(%rbp), %bl
	notb	%bl
	movb	%bl, -70(%rbp)
/*t5[11] = t11*/
	movq	-64(%rbp), %rcx
	movq	$11, %rbx
	addq	%rbx, %rcx
	movb	-70(%rbp), %bl
	movb	%bl, (%rcx)
/*booleanArray = t5*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*t12 = new array[4]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -86(%rbp)
/*t12[0] = 4*/
	movq	-86(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t13 = "Juan\n"*/
	movq	str_6@GOTPCREL(%rip), %rax
	movq	%rax, -94(%rbp)
/*t12[8] = t13*/
	movq	-86(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-94(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t14 = "Pedro\n"*/
	movq	str_7@GOTPCREL(%rip), %rax
	movq	%rax, -102(%rbp)
/*t12[16] = t14*/
	movq	-86(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-102(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t15 = "Sara\n"*/
	movq	str_8@GOTPCREL(%rip), %rax
	movq	%rax, -110(%rbp)
/*t12[24] = t15*/
	movq	-86(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-110(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t16 = "Antonio\n"*/
	movq	str_9@GOTPCREL(%rip), %rax
	movq	%rax, -118(%rbp)
/*t12[32] = t16*/
	movq	-86(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-118(%rbp), %rbx
	movq	%rbx, (%rcx)
/*stringArray = t12*/
	movq	-86(%rbp), %rax
	movq	%rax, -78(%rbp)
/*t17 = 2*/
	movq	$2, %rax
	movq	%rax, -126(%rbp)
/*t18 = t17 * 8*/
	movq	-126(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -134(%rbp)
/*t18 = t18 + 8*/
	movq	-134(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -134(%rbp)
/*t19 = intArray[t18]*/
	movq	-8(%rbp), %rax
	movq	-134(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -142(%rbp)
/*printInt(t19)*/
	movq	-142(%rbp), %rdi
	call	print_uint64
/*t20 = 2*/
	movq	$2, %rax
	movq	%rax, -150(%rbp)
/*t21 = t20 * 1*/
	movq	-150(%rbp), %rax
	movq	$1, %rbx
	imulq	%rbx, %rax
	movq	%rax, -158(%rbp)
/*t21 = t21 + 8*/
	movq	-158(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -158(%rbp)
/*t22 = booleanArray[t21]*/
	movq	-56(%rbp), %rax
	movq	-158(%rbp), %rbx
	addq	%rbx, %rax
	movb	(%rax), %al
	movb	%al, -159(%rbp)
/*printBoolean(t22)*/
	movb	-159(%rbp), %bl
	call	print_boolean
/*t23 = 2*/
	movq	$2, %rax
	movq	%rax, -167(%rbp)
/*t24 = t23 * 8*/
	movq	-167(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -175(%rbp)
/*t24 = t24 + 8*/
	movq	-175(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -175(%rbp)
/*t25 = stringArray[t24]*/
	movq	-78(%rbp), %rax
	movq	-175(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -183(%rbp)
/*printString(t25)*/
	movq	-183(%rbp), %rsi
	call	print_string
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/**
 * Prints a boolean to stdout
 * Params:
 * - %bl: Boolean value
 */
print_boolean:
	testb	%bl, %bl
	jnz 	.print_boolean_true
	movq	decl_1@GOTPCREL(%rip), %rsi
	jmp 	.print_boolean_end
	.print_boolean_true:
		movq	decl_0@GOTPCREL(%rip), %rsi
	.print_boolean_end:
		call 	print_string
		ret

/**
 * Returns a string's length (saves to %rdx)
 * Params:
 * - %rsi: String address
 * https://stackoverflow.com/questions/60482733/how-to-traverse-a-string-in-assembly-until-i-reach-null-strlen-loop
 */
string_length:
	lea 	-1(%rsi), %rdx
	.Lloop:
		inc 	%rdx
		cmpb	$0, (%rdx)
		jne 	.Lloop
	sub 	%rsi, %rdx
	ret

/**
 * Prints a string to stdout
 * Params:
 * - %rsi: String address
 */
print_string:
	call	string_length
	mov 	$0x02000004, %rax
	mov 	$1, %rdi
	syscall
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
	arr_3: .fill 40, 1
	arr_4: .fill 12, 1
	arr_5: .fill 40, 1
	str_6: .asciz "Juan\n"
	str_7: .asciz "Pedro\n"
	str_8: .asciz "Sara\n"
	str_9: .asciz "Antonio\n"
