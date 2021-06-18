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
	subq	$72, %rsp
/*t0 = new array[3]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 3*/
	movq	-16(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = -1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movb	$-1, %bl
	movb	%bl, (%rcx)
/*t0[9] = 0*/
	movq	-16(%rbp), %rcx
	movq	$9, %rbx
	addq	%rbx, %rcx
	movb	$0, %bl
	movb	%bl, (%rcx)
/*t0[10] = 0*/
	movq	-16(%rbp), %rcx
	movq	$10, %rbx
	addq	%rbx, %rcx
	movb	$0, %bl
	movb	%bl, (%rcx)
/*a = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t4 = new array[3]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -32(%rbp)
/*t4[0] = 3*/
	movq	-32(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t5 = new array[1]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -40(%rbp)
/*t5[0] = 1*/
	movq	-40(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t5[8] = 7*/
	movq	-40(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$7, %rbx
	movq	%rbx, (%rcx)
/*t4[8] = t5*/
	movq	-32(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t7 = new array[1]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -48(%rbp)
/*t7[0] = 1*/
	movq	-48(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t7[8] = 8*/
	movq	-48(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*t4[16] = t7*/
	movq	-32(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-48(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = new array[1]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -56(%rbp)
/*t9[0] = 1*/
	movq	-56(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t9[8] = 9*/
	movq	-56(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t4[24] = t9*/
	movq	-32(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-56(%rbp), %rbx
	movq	%rbx, (%rcx)
/*b = t4*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*printArray(a)*/
	movq	str_8@GOTPCREL(%rip), %rsi
	call	print_string
/*printArray(b)*/
	movq	str_9@GOTPCREL(%rip), %rsi
	call	print_string
/*t11 = new array[1]*/
	movq	arr_10@GOTPCREL(%rip), %rax
	movq	%rax, -64(%rbp)
/*t11[0] = 1*/
	movq	-64(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t11[8] = 8*/
	movq	-64(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$8, %rbx
	movq	%rbx, (%rcx)
/*printArray(t11)*/
	movq	str_11@GOTPCREL(%rip), %rsi
	call	print_string
/*t15 = new array[0]*/
	movq	arr_12@GOTPCREL(%rip), %rax
	movq	%rax, -72(%rbp)
/*t15[0] = 0*/
	movq	-72(%rbp), %rcx
	movq	$0, %rbx
	movq	%rbx, (%rcx)
/*printArray(t15)*/
	movq	str_13@GOTPCREL(%rip), %rsi
	call	print_string
/*rtn s0*/
	movq	%rbp, %rsp
	pop 	%rbp
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

.section __DATA, __data
	decl_0: .asciz "true\n"
	decl_1: .asciz "false\n"
	decl_2: .quad 0
	arr_3: .fill 11, 1
	arr_4: .fill 32, 1
	arr_5: .fill 16, 1
	arr_6: .fill 16, 1
	arr_7: .fill 16, 1
	str_8: .asciz "Array BOOLEAN[]\n"
	str_9: .asciz "Array INT[][]\n"
	arr_10: .fill 16, 1
	str_11: .asciz "Array INT[]\n"
	arr_12: .fill 8, 1
	str_13: .asciz "Array UNKNOWN[]\n"
