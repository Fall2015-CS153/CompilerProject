.class public TestPassByValue
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/lang/String;
.field private static b I
.field private static d I
.field private static f Ljava/lang/String;
.field private static temp Ljava/lang/String;
.field private static x I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
    ldc "abc"
    putstatic TestPassByValue/a Ljava/lang/String;
    ldc 5
    putstatic TestPassByValue/b I
    ldc "Inside main a before call to function "
    getstatic TestPassByValue/a Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside main a before call to function "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/a Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "Inside main b before call to function "
    getstatic TestPassByValue/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside main b before call to function "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    new TestPassByValue
    dup
    invokespecial TestPassByValue/<init>()V
    getstatic TestPassByValue/a Ljava/lang/String;
    getstatic TestPassByValue/b I
    invokevirtual TestPassByValue/second(Ljava/lang/String;I)V
    ldc "After return  a is "
    getstatic TestPassByValue/a Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "After return  a is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/a Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "After return  b is "
    getstatic TestPassByValue/b I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "After return  b is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/b I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop

return
.limit locals 32
.limit stack 40
.end method

.method public second(Ljava/lang/String;I)V
    aload_1
    putstatic TestPassByValue/f Ljava/lang/String;
    iload_2
    putstatic TestPassByValue/d I


    getstatic TestPassByValue/f Ljava/lang/String;
    putstatic TestPassByValue/temp Ljava/lang/String;
    getstatic TestPassByValue/d I
    putstatic TestPassByValue/x I
    ldc "Inside proc Passed value is "
    getstatic TestPassByValue/temp Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside proc Passed value is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/temp Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "Inside proc Passed value is "
    getstatic TestPassByValue/x I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside proc Passed value is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/x I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "dog"
    putstatic TestPassByValue/temp Ljava/lang/String;
    ldc 7
    putstatic TestPassByValue/x I
    ldc "Inside proc Changed value is "
    getstatic TestPassByValue/temp Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside proc Changed value is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/temp Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop
    ldc "Inside proc Changed value is "
    getstatic TestPassByValue/x I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Inside proc Changed value is "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic TestPassByValue/x I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    pop
    pop

return
.limit locals 32
.limit stack 40
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	TestPassByValue/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	TestPassByValue/_standardIn LPascalTextIn;

 new TestPassByValue
    dup
    invokespecial TestPassByValue/<init>()V
    invokevirtual TestPassByValue/main()V

    getstatic	TestPassByValue/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 7
.limit stack  16
.end method
