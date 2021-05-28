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
	subq	$88, %rsp
/*t0 = new array[5]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 4*/
	movq	-16(%rbp), %rcx
	movq	$0, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t3 = 37 + 28*/
	movq	$37, %rax
	movq	$28, %rbx
	addq	%rbx, %rax
	movq	%rax, -24(%rbp)
/*t0[8] = t3*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-24(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t6 = 89 + 4*/
	movq	$89, %rax
	movq	$4, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t0[16] = t6*/
	movq	-16(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-32(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = 25 + 3*/
	movq	$25, %rax
	movq	$3, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*t0[24] = t9*/
	movq	-16(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t12 = 84 + 8*/
	movq	$84, %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -48(%rbp)
/*t0[32] = t12*/
	movq	-16(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*arr = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*i = 0*/
	movq	$0, %rax
	movq	%rax, -56(%rbp)
/*e0: skip*/
e0:
/*t14 = arr[0]*/
	movq	-8(%rbp), %rax
	movq	$0, %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -64(%rbp)
/*if i < t14 goto e1*/
	movq	-56(%rbp), %rax
	movq	-64(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t15 = 0*/
	movq	$0, %rax
	movq	%rax, -72(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t15 = -1*/
	movq	$-1, %rax
	movq	%rax, -72(%rbp)
/*e2: skip*/
e2:
/*if t15 = 0 goto e3*/
	movq	-72(%rbp), %rax
	movq	$0, %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e3
1:
/*t16 = i + 1*/
	movq	-56(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*t16 = t16 * 8*/
	movq	-80(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -80(%rbp)
/*t17 = arr[t16]*/
	movq	-8(%rbp), %rax
	movq	-80(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -88(%rbp)
/*printInt(t17)*/
	movq	-88(%rbp), %rdi
	call	print_uint64
/*i = i + 1*/
	movq	-56(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -56(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
	ret

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	arr_3: .quad 5
