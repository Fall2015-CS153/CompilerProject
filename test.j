.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static doDob F

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Test/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Test/_standardIn LPascalTextIn;

    ldc 4
    ldc 10.0
    getstatic Test/a I
    ldc 5
    fadd
    putstatic Test/null F
    putstatic Test/a I
    getstatic Test/a I
    ldc 5
    imul
    putstatic Test/a I
    getstatic Test/a I
    ldc 5
    isub
    putstatic Test/a I
    getstatic Test/doDob F
    ldc 10
    fdiv
    putstatic Test/doDob F
    getstatic Test/doDob F
    ldc 12
    fadd
    putstatic Test/doDob F
    getstatic	Test/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
