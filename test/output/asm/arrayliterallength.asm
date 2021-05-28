.section	__TEXT, __text
	.globl	_main
	.globl	print_uint64
	.globl	print_boolean
	.globl	print_string
	.globl	read_string
	.globl	string_length
	.globl	compare_strings
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

/**
 * Reads a string from stdin
 * Params:
 * - %rsi: Address where the string will be saved
 */
read_string:
	mov 	$0x02000003, %rax
	mov 	$0, %rdi
	movq	$140, %rdx
	syscall
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
 * Compares two strings (saves result to %rdx)
 * Params:
 * - %rsi: First string address
 * - %rdi: Second string address
 */
compare_strings:
	lea 	-1(%rsi), %rcx
	lea 	-1(%rdi), %rdx
	.Cloop:
		inc 	%rcx
		inc 	%rdx
		cmpb	$0, (%rcx)
		jne 	.compare_strings_continue
		cmpb	$0, (%rdx)
		je  	.compare_strings_true
		.compare_strings_continue:
			movb	(%rcx), %al
			cmpb	%al, (%rdx)
			je  	.Cloop
	.compare_strings_false:
		movq	$0, %rdx
		jmp 	.compare_strings_end
	.compare_strings_true:
		movq	$-1, %rdx
	.compare_strings_end:
		ret

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
	subq	$152, %rsp
/*t0 = new array[4]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -8(%rbp)
/*t0[0] = 3*/
	movq	-8(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 3*/
	movq	-8(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 2*/
	movq	-8(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t4 = - 7*/
	xorq 	%rax, %rax
	movq	$7, %rbx
	subq	%rbx, %rax
	movq	%rax, -16(%rbp)
/*t0[24] = t4*/
	movq	-8(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-16(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t5 = t0[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -24(%rbp)
/*printInt(t5)*/
	movq	-24(%rbp), %rdi
	call	print_uint64
/*t6 = new array[5]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -40(%rbp)
/*t6[0] = 4*/
	movq	-40(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t6[8] = 3*/
	movq	-40(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t6[16] = 4*/
	movq	-40(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t6[24] = 5*/
	movq	-40(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t11 = - 6*/
	xorq 	%rax, %rax
	movq	$6, %rbx
	subq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t6[32] = t11*/
	movq	-40(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t6*/
	movq	-40(%rbp), %rax
	movq	%rax, -32(%rbp)
/*t12 = arr[0]*/
	movq	-32(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -56(%rbp)
/*printInt(t12)*/
	movq	-56(%rbp), %rdi
	call	print_uint64
/*t13 = arr[0]*/
	movq	-32(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -64(%rbp)
/*t14 = new array[3]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -72(%rbp)
/*t14[0] = 2*/
	movq	-72(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t14[8] = 3*/
	movq	-72(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t14[16] = 2*/
	movq	-72(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t17 = t14[0]*/
	movq	-72(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -80(%rbp)
/*t18 = t13 + t17*/
	movq	-64(%rbp), %rax
	movq	-80(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*t19 = new array[4]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -96(%rbp)
/*t19[0] = 3*/
	movq	-96(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t21 = - 8*/
	xorq 	%rax, %rax
	movq	$8, %rbx
	subq	%rbx, %rax
	movq	%rax, -104(%rbp)
/*t19[8] = t21*/
	movq	-96(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-104(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t19[16] = 9*/
	movq	-96(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t25 = 45 + 3*/
	movq	$45, %rax
	movq	$3, %rbx
	addq	%rbx, %rax
	movq	%rax, -112(%rbp)
/*t19[24] = t25*/
	movq	-96(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-112(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t26 = t19[0]*/
	movq	-96(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -120(%rbp)
/*t27 = t18 + t26*/
	movq	-88(%rbp), %rax
	movq	-120(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -128(%rbp)
/*t28 = new array[2]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -136(%rbp)
/*t28[0] = 1*/
	movq	-136(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[8] = 1*/
	movq	-136(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t30 = t28[0]*/
	movq	-136(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -144(%rbp)
/*t31 = t27 + t30*/
	movq	-128(%rbp), %rax
	movq	-144(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -152(%rbp)
/*printInt(t31)*/
	movq	-152(%rbp), %rdi
	call	print_uint64
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	arr_3: .quad 4
	arr_4: .quad 5
	arr_5: .quad 3
	arr_6: .quad 4
	arr_7: .quad 2
