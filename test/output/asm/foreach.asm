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
	subq	$112, %rsp
/*t0 = new array[17]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 16*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$16, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = 1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = 2*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t0[24] = 3*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[32] = 4*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t0[40] = 5*/
	movq	-16(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t0[48] = 6*/
	movq	-16(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t0[56] = 7*/
	movq	-16(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	$7, %rbx
	movq	%rbx, (%rcx)
/*t0[64] = 8*/
	movq	-16(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*t10 = - 1*/
	xorq 	%rax, %rax
	movq	$1, %rbx
	subq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*t0[72] = t10*/
	movq	-16(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t12 = - 2*/
	xorq 	%rax, %rax
	movq	$2, %rbx
	subq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t0[80] = t12*/
	movq	-16(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t14 = - 3*/
	xorq 	%rax, %rax
	movq	$3, %rbx
	subq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t0[88] = t14*/
	movq	-16(%rbp), %rcx
	movq	$88, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t16 = - 4*/
	xorq 	%rax, %rax
	movq	$4, %rbx
	subq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t0[96] = t16*/
	movq	-16(%rbp), %rcx
	movq	$96, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t18 = - 5*/
	xorq 	%rax, %rax
	movq	$5, %rbx
	subq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*t0[104] = t18*/
	movq	-16(%rbp), %rcx
	movq	$104, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t20 = - 6*/
	xorq 	%rax, %rax
	movq	$6, %rbx
	subq	%rbx, %rax
	movq	%rax, -64(%rbp)
/*t0[112] = t20*/
	movq	-16(%rbp), %rcx
	movq	$112, %rbx
	addq	%rbx, %rcx
	movq	-64(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t22 = - 7*/
	xorq 	%rax, %rax
	movq	$7, %rbx
	subq	%rbx, %rax
	movq	%rax, -72(%rbp)
/*t0[120] = t22*/
	movq	-16(%rbp), %rcx
	movq	$120, %rbx
	addq	%rbx, %rcx
	movq	-72(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t24 = - 8*/
	xorq 	%rax, %rax
	movq	$8, %rbx
	subq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*t0[128] = t24*/
	movq	-16(%rbp), %rcx
	movq	$128, %rbx
	addq	%rbx, %rcx
	movq	-80(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t25 = 0*/
	movq	$0, %rax
	movq	%rax, -88(%rbp)
/*t27 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -104(%rbp)
/*el = 0*/
	movq	$0, %rax
	movq	%rax, -112(%rbp)
/*e0: skip*/
e0:
/*if t25 = t27 goto e1*/
	movq	-88(%rbp), %rax
	movq	-104(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e1
1:
/*t26 = t25 + 1*/
	movq	-88(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*t26 = t26 * 8*/
	movq	-96(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -96(%rbp)
/*el = arr[t26]*/
	movq	-8(%rbp), %rax
	movq	-96(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -112(%rbp)
/*printInt(el)*/
	movq	-112(%rbp), %rdi
	call	print_uint64
/*t25 = t25 + 1*/
	movq	-88(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -88(%rbp)
/*goto e0*/
	jmp 	e0
/*e1: skip*/
e1:
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	arr_3: .fill 17, 8