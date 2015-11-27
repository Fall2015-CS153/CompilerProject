.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a I
.field private static c I
.field private static doDob F
.field private static fort F

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc 4
    ldc 10.2
    getstatic Test/a I
    ldc 5
    imul
    putstatic Test/a I
    getstatic Test/a I
    ldc 5
    isub
    putstatic Test/a I

return
.limit locals 16
.limit stack 16
.end method

.method public second()V
    ldc 5
    ldc 6.0

return
.limit locals 16
.limit stack 16
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

 new Test
    dup
    invokespecial Test/<init>()V
    invokevirtual Test/main()V

    getstatic	Test/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
