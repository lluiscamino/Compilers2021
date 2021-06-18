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
	subq	$123, %rsp
/*t0 = new array[3]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -16(%rbp)
/*t0[0] = 3*/
	movq	-16(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t1 = -1*/
	movb	$-1, %al
	movb	%al, -17(%rbp)
/*t0[8] = t1*/
	movq	-16(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movb	-17(%rbp), %bl
	movb	%bl, (%rcx)
/*t2 = 0*/
	movb	$0, %al
	movb	%al, -18(%rbp)
/*t0[9] = t2*/
	movq	-16(%rbp), %rcx
	movq	$9, %rbx
	addq	%rbx, %rcx
	movb	-18(%rbp), %bl
	movb	%bl, (%rcx)
/*t3 = 0*/
	movb	$0, %al
	movb	%al, -19(%rbp)
/*t0[10] = t3*/
	movq	-16(%rbp), %rcx
	movq	$10, %rbx
	addq	%rbx, %rcx
	movb	-19(%rbp), %bl
	movb	%bl, (%rcx)
/*a = t0*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t4 = new array[3]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -35(%rbp)
/*t4[0] = 3*/
	movq	-35(%rbp), %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t5 = new array[1]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -43(%rbp)
/*t5[0] = 1*/
	movq	-43(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t6 = 7*/
	movq	$7, %rax
	movq	%rax, -51(%rbp)
/*t5[8] = t6*/
	movq	-43(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-51(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4[8] = t5*/
	movq	-35(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-43(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t7 = new array[1]*/
	movq	arr_6@GOTPCREL(%rip), %rax
	movq	%rax, -59(%rbp)
/*t7[0] = 1*/
	movq	-59(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t8 = 8*/
	movq	$8, %rax
	movq	%rax, -67(%rbp)
/*t7[8] = t8*/
	movq	-59(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-67(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4[16] = t7*/
	movq	-35(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-59(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t9 = new array[1]*/
	movq	arr_7@GOTPCREL(%rip), %rax
	movq	%rax, -75(%rbp)
/*t9[0] = 1*/
	movq	-75(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t10 = 9*/
	movq	$9, %rax
	movq	%rax, -83(%rbp)
/*t9[8] = t10*/
	movq	-75(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-83(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t4[24] = t9*/
	movq	-35(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	-75(%rbp), %rbx
	movq	%rbx, (%rcx)
/*b = t4*/
	movq	-35(%rbp), %rax
	movq	%rax, -27(%rbp)
/*printArray(a)*/
	movq	str_8@GOTPCREL(%rip), %rsi
	call	print_string
/*printArray(b)*/
	movq	str_9@GOTPCREL(%rip), %rsi
	call	print_string
/*t11 = new array[1]*/
	movq	arr_10@GOTPCREL(%rip), %rax
	movq	%rax, -91(%rbp)
/*t11[0] = 1*/
	movq	-91(%rbp), %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t12 = 3*/
	movq	$3, %rax
	movq	%rax, -99(%rbp)
/*t13 = 5*/
	movq	$5, %rax
	movq	%rax, -107(%rbp)
/*t14 = t12 + t13*/
	movq	-99(%rbp), %rax
	movq	-107(%rbp), %rbx
	addq	%rbx, %rax
	movq	%rax, -115(%rbp)
/*t11[8] = t14*/
	movq	-91(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-115(%rbp), %rbx
	movq	%rbx, (%rcx)
/*printArray(t11)*/
	movq	str_11@GOTPCREL(%rip), %rsi
	call	print_string
/*t15 = new array[0]*/
	movq	arr_12@GOTPCREL(%rip), %rax
	movq	%rax, -123(%rbp)
/*t15[0] = 0*/
	movq	-123(%rbp), %rcx
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
