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
/*t_main: skip*/
	call	t_main
	mov 	$0x02000001, %rax
	xor 	$0, %rdi
	syscall
t_main:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$112, %rsp
/*t0 = new array[5]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 4*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 3*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 8*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*t0[24] = 24*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$24, %rbx
	movq	%rbx, (%rcx)
/*t0[32] = 9*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*intArray = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t5 = new array[5]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -32(%rbp)
/*t5[0] = 4*/
	movq	-32(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t5[8] = -1*/
	movq	-32(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$-1, %rbx
	movq	%rbx, (%rcx)
/*t5[16] = 0*/
	movq	-32(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*t9 = 0*/
	movq	$0, %rax
	movq	%rax, -40(%rbp)
/*t5[24] = t9*/
	movq	-32(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t11 = -1*/
	movq	$-1, %rax
	movq	%rax, -48(%rbp)
/*t5[32] = t11*/
	movq	-32(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*booleanArray = t5*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*t12 = new array[5]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -64(%rbp)
/*t12[0] = 4*/
	movq	-64(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t12[8] = "Juan\n"*/
	movq	-64(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	str_6@GOTPCREL(%rip), %rbx
	movq	%rbx, (%rcx)
/*t12[16] = "Pedro\n"*/
	movq	-64(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	str_7@GOTPCREL(%rip), %rbx
	movq	%rbx, (%rcx)
/*t12[24] = "Sara\n"*/
	movq	-64(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	str_8@GOTPCREL(%rip), %rbx
	movq	%rbx, (%rcx)
/*t12[32] = "Antonio\n"*/
	movq	-64(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	str_9@GOTPCREL(%rip), %rbx
	movq	%rbx, (%rcx)
/*stringArray = t12*/
	movq	-64(%rbp), %rax
	movq	%rax, -56(%rbp)
/*t18 = 3*/
	movq	$3, %rax
	movq	%rax, -72(%rbp)
/*t18 = t18 * 8*/
	movq	-72(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t19 = intArray[t18]*/
	movq	-8(%rbp), %rax
	movq	-72(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -80(%rbp)
/*printInt(t19)*/
	movq	-80(%rbp), %rdi
	call	print_uint64
/*t21 = 3*/
	movq	$3, %rax
	movq	%rax, -88(%rbp)
/*t21 = t21 * 8*/
	movq	-88(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*t22 = booleanArray[t21]*/
	movq	-24(%rbp), %rax
	movq	-88(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -96(%rbp)
/*printBoolean(t22)*/
	movq	-96(%rbp), %rbx
	call	print_boolean
/*t24 = 3*/
	movq	$3, %rax
	movq	%rax, -104(%rbp)
/*t24 = t24 * 8*/
	movq	-104(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -104(%rbp)
/*t25 = stringArray[t24]*/
	movq	-56(%rbp), %rax
	movq	-104(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -112(%rbp)
/*printString(t25)*/
	movq	-112(%rbp), %rsi
	call	print_string
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/**
 * Prints a boolean to stdout
 * Params:
 * - %rbx: Boolean value
 */
print_boolean:
	testl	%ebx, %ebx
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
	arr_3: .fill 5, 8
	arr_4: .fill 5, 8
	arr_5: .fill 5, 8
	str_6: .asciz "Juan\n"
	str_7: .asciz "Pedro\n"
	str_8: .asciz "Sara\n"
	str_9: .asciz "Antonio\n"
