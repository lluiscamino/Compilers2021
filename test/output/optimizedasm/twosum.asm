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
/*t_twoSum: skip*/
t_twoSum:
/*pmb s0*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$120, %rsp
/*t0 = new array[2]*/
	movq	arr_3@GOTPCREL(%rip), %rax
	movq	%rax, -32(%rbp)
/*t0[0] = 2*/
	movq	-32(%rbp), %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t0[8] = -1*/
	movq	-32(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$-1, %rbx
	movq	%rbx, (%rcx)
/*t0[16] = -1*/
	movq	-32(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$-1, %rbx
	movq	%rbx, (%rcx)
/*result = t0*/
	movq	-32(%rbp), %rax
	movq	%rax, -24(%rbp)
/*i = 0*/
	movq	$0, %rax
	movq	%rax, -40(%rbp)
/*res = 0*/
	movb	$0, %al
	movb	%al, -41(%rbp)
/*e0: skip*/
e0:
/*t7 = nums[0]*/
	movq	16(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -49(%rbp)
/*if i < t7 goto e1*/
	movq	-40(%rbp), %rax
	movq	-49(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e1
1:
/*t8 = 0*/
	movb	$0, %al
	movb	%al, -50(%rbp)
/*goto e2*/
	jmp 	e2
/*e1: skip*/
e1:
/*t8 = -1*/
	movb	$-1, %al
	movb	%al, -50(%rbp)
/*e2: skip*/
e2:
/*t9 = not res*/
	movb	-41(%rbp), %bl
	notb	%bl
	movb	%bl, -51(%rbp)
/*t10 = t8 and t9*/
	movb	-50(%rbp), %al
	movb	-51(%rbp), %bl
	andb	%bl, %al
	movb	%al, -52(%rbp)
/*if t10 = 0 goto e3*/
	movb	-52(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e3
1:
/*j = 0*/
	movq	$0, %rax
	movq	%rax, -60(%rbp)
/*e4: skip*/
e4:
/*t12 = nums[0]*/
	movq	16(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, -68(%rbp)
/*if j < t12 goto e5*/
	movq	-60(%rbp), %rax
	movq	-68(%rbp), %rbx
	cmpq	%rbx, %rax
	jge 	1f
	jmp	e5
1:
/*t13 = 0*/
	movb	$0, %al
	movb	%al, -69(%rbp)
/*goto e6*/
	jmp 	e6
/*e5: skip*/
e5:
/*t13 = -1*/
	movb	$-1, %al
	movb	%al, -69(%rbp)
/*e6: skip*/
e6:
/*t14 = not res*/
	movb	-41(%rbp), %bl
	notb	%bl
	movb	%bl, -70(%rbp)
/*t15 = t13 and t14*/
	movb	-69(%rbp), %al
	movb	-70(%rbp), %bl
	andb	%bl, %al
	movb	%al, -71(%rbp)
/*if t15 = 0 goto e7*/
	movb	-71(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e7
1:
/*t16 = i * 8*/
	movq	-40(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -79(%rbp)
/*t16 = t16 + 8*/
	movq	-79(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -79(%rbp)
/*t17 = nums[t16]*/
	movq	16(%rbp), %rax
	movq	-79(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -87(%rbp)
/*t18 = j * 8*/
	movq	-60(%rbp), %rax
	movq	$8, %rbx
	imulq	%rbx, %rax
	movq	%rax, -95(%rbp)
/*t18 = t18 + 8*/
	movq	-95(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -95(%rbp)
/*t19 = nums[t18]*/
	movq	16(%rbp), %rax
	movq	-95(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -103(%rbp)
/*t20 = target - t19*/
	movq	24(%rbp), %rax
	movq	-103(%rbp), %rbx
	subq	%rbx, %rax
	movq	%rax, -111(%rbp)
/*if t17 = t20 goto e8*/
	movq	-87(%rbp), %rax
	movq	-111(%rbp), %rbx
	cmpq	%rbx, %rax
	jne 	1f
	jmp	e8
1:
/*t21 = 0*/
	movb	$0, %al
	movb	%al, -112(%rbp)
/*goto e9*/
	jmp 	e9
/*e8: skip*/
e8:
/*t21 = -1*/
	movb	$-1, %al
	movb	%al, -112(%rbp)
/*e9: skip*/
e9:
/*if t21 = 0 goto e10*/
	movb	-112(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e10
1:
/*t22 = new array[2]*/
	movq	arr_4@GOTPCREL(%rip), %rax
	movq	%rax, -120(%rbp)
/*t22[0] = 2*/
	movq	-120(%rbp), %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t22[8] = i*/
	movq	-120(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	-40(%rbp), %rbx
	movq	%rbx, (%rcx)
/*t22[16] = j*/
	movq	-120(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	-60(%rbp), %rbx
	movq	%rbx, (%rcx)
/*result = t22*/
	movq	-120(%rbp), %rax
	movq	%rax, -24(%rbp)
/*res = -1*/
	movb	$-1, %al
	movb	%al, -41(%rbp)
/*e10: skip*/
e10:
/*j = j + 1*/
	movq	-60(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -60(%rbp)
/*goto e4*/
	jmp 	e4
/*e7: skip*/
e7:
/*i = i + 1*/
	movq	-40(%rbp), %rax
	movq	$1, %rbx
	addq	%rbx, %rax
	movq	%rax, -40(%rbp)
/*goto e0*/
	jmp 	e0
/*e3: skip*/
e3:
/*rtn s0: result*/
	movq	-24(%rbp), %rax
	movq	%rbp, %rsp
	pop 	%rbp
	ret

/*t_main: skip*/
t_main:
/*pmb s1*/
	push	%rbp
	mov 	%rsp, %rbp
	subq	$91, %rsp
/*t28 = new array[17]*/
	movq	arr_5@GOTPCREL(%rip), %rax
	movq	%rax, -24(%rbp)
/*t28[0] = 17*/
	movq	-24(%rbp), %rcx
	movq	$17, %rbx
	movq	%rbx, (%rcx)
/*t28[8] = 6*/
	movq	-24(%rbp), %rcx
	movq	$8, %rbx
	addq	%rbx, %rcx
	movq	$6, %rbx
	movq	%rbx, (%rcx)
/*t28[16] = 4*/
	movq	-24(%rbp), %rcx
	movq	$16, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*t28[24] = 3*/
	movq	-24(%rbp), %rcx
	movq	$24, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t28[32] = 9*/
	movq	-24(%rbp), %rcx
	movq	$32, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t28[40] = 5*/
	movq	-24(%rbp), %rcx
	movq	$40, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t28[48] = 3*/
	movq	-24(%rbp), %rcx
	movq	$48, %rbx
	addq	%rbx, %rcx
	movq	$3, %rbx
	movq	%rbx, (%rcx)
/*t28[56] = 1*/
	movq	-24(%rbp), %rcx
	movq	$56, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[64] = 1*/
	movq	-24(%rbp), %rcx
	movq	$64, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[72] = 5*/
	movq	-24(%rbp), %rcx
	movq	$72, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t28[80] = 5*/
	movq	-24(%rbp), %rcx
	movq	$80, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t28[88] = 1*/
	movq	-24(%rbp), %rcx
	movq	$88, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[96] = 9*/
	movq	-24(%rbp), %rcx
	movq	$96, %rbx
	addq	%rbx, %rcx
	movq	$9, %rbx
	movq	%rbx, (%rcx)
/*t28[104] = 5*/
	movq	-24(%rbp), %rcx
	movq	$104, %rbx
	addq	%rbx, %rcx
	movq	$5, %rbx
	movq	%rbx, (%rcx)
/*t28[112] = 7*/
	movq	-24(%rbp), %rcx
	movq	$112, %rbx
	addq	%rbx, %rcx
	movq	$7, %rbx
	movq	%rbx, (%rcx)
/*t28[120] = 1*/
	movq	-24(%rbp), %rcx
	movq	$120, %rbx
	addq	%rbx, %rcx
	movq	$1, %rbx
	movq	%rbx, (%rcx)
/*t28[128] = 2*/
	movq	-24(%rbp), %rcx
	movq	$128, %rbx
	addq	%rbx, %rcx
	movq	$2, %rbx
	movq	%rbx, (%rcx)
/*t28[136] = 4*/
	movq	-24(%rbp), %rcx
	movq	$136, %rbx
	addq	%rbx, %rcx
	movq	$4, %rbx
	movq	%rbx, (%rcx)
/*param 11*/
	movq	$11, %rax
	push	%rax
/*param t28*/
	movq	-24(%rbp), %rax
	push	%rax
/*t26 = call s0*/
	call	t_twoSum
	movq	%rax, -16(%rbp)
/*result = t26*/
	movq	-16(%rbp), %rax
	movq	%rax, -8(%rbp)
/*t47 = 0*/
	movq	$0, %rax
	movq	%rax, -32(%rbp)
/*t47 = t47 + 8*/
	movq	-32(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -32(%rbp)
/*t48 = result[t47]*/
	movq	-8(%rbp), %rax
	movq	-32(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -40(%rbp)
/*if t48 != -1 goto e11*/
	movq	-40(%rbp), %rax
	movq	$-1, %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e11
1:
/*t51 = 0*/
	movb	$0, %al
	movb	%al, -41(%rbp)
/*goto e12*/
	jmp 	e12
/*e11: skip*/
e11:
/*t51 = -1*/
	movb	$-1, %al
	movb	%al, -41(%rbp)
/*e12: skip*/
e12:
/*t53 = 8*/
	movq	$8, %rax
	movq	%rax, -49(%rbp)
/*t53 = t53 + 8*/
	movq	-49(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -49(%rbp)
/*t54 = result[t53]*/
	movq	-8(%rbp), %rax
	movq	-49(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -57(%rbp)
/*if t54 != -1 goto e13*/
	movq	-57(%rbp), %rax
	movq	$-1, %rbx
	cmpq	%rbx, %rax
	je 	1f
	jmp	e13
1:
/*t57 = 0*/
	movb	$0, %al
	movb	%al, -58(%rbp)
/*goto e14*/
	jmp 	e14
/*e13: skip*/
e13:
/*t57 = -1*/
	movb	$-1, %al
	movb	%al, -58(%rbp)
/*e14: skip*/
e14:
/*t58 = t51 or t57*/
	movb	-41(%rbp), %al
	movb	-58(%rbp), %bl
	orb 	%bl, %al
	movb	%al, -59(%rbp)
/*if t58 = 0 goto e15*/
	movb	-59(%rbp), %al
	movb	$0, %bl
	cmpb	%bl, %al
	jne 	1f
	jmp	e15
1:
/*printString("Resultado: \n")*/
	movq	str_6@GOTPCREL(%rip), %rsi
	call	print_string
/*t61 = 0*/
	movq	$0, %rax
	movq	%rax, -67(%rbp)
/*t61 = t61 + 8*/
	movq	-67(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -67(%rbp)
/*t62 = result[t61]*/
	movq	-8(%rbp), %rax
	movq	-67(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -75(%rbp)
/*printInt(t62)*/
	movq	-75(%rbp), %rdi
	call	print_uint64
/*t64 = 8*/
	movq	$8, %rax
	movq	%rax, -83(%rbp)
/*t64 = t64 + 8*/
	movq	-83(%rbp), %rax
	movq	$8, %rbx
	addq	%rbx, %rax
	movq	%rax, -83(%rbp)
/*t65 = result[t64]*/
	movq	-8(%rbp), %rax
	movq	-83(%rbp), %rbx
	addq	%rbx, %rax
	movq	(%rax), %rax
	movq	%rax, -91(%rbp)
/*printInt(t65)*/
	movq	-91(%rbp), %rdi
	call	print_uint64
/*goto e16*/
	jmp 	e16
/*e15: skip*/
e15:
/*printString("Sin resultado\n")*/
	movq	str_7@GOTPCREL(%rip), %rsi
	call	print_string
/*e16: skip*/
e16:
/*rtn s1*/
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
	arr_3: .fill 24, 1
	arr_4: .fill 24, 1
	arr_5: .fill 144, 1
	str_6: .asciz "Resultado: \n"
	str_7: .asciz "Sin resultado\n"
