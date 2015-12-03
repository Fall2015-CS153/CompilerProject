.class public Test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.field private static a Ljava/util/ArrayList;
.field private static b Ljava/lang/String;
.field private static c Ljava/lang/String;
.field private static d I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public main()V
new  List
dup
astore_0
aload_0
invokespecial List.<init>()V
invokevirtual List/StringList()Ljava/util/ArrayList;
putstatic Test/a Ljava/util/ArrayList;
aload_0
ldc "abc"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
ldc "cde"
invokevirtual List/add(Ljava/lang/String;)V
aload_0
ldc 0
invokevirtual List/getVal(I)Ljava/lang/String;
    putstatic Test/b Ljava/lang/String;
    ldc "Val "
    getstatic Test/b Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/b Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

aload_0
ldc 1
invokevirtual List/getVal(I)Ljava/lang/String;
    putstatic Test/c Ljava/lang/String;
    ldc "Val "
    getstatic Test/c Ljava/lang/String;

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/c Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

aload_0
ldc "cde"
invokevirtual List/remove(Ljava/lang/String;)V
aload_0
ldc 0
ldc "what"
invokevirtual List/setVal(ILjava/lang/String;)V
aload_0
ldc "what"
invokevirtual List/getIndex(Ljava/lang/String;)I
    putstatic Test/d I
    ldc "Val "
    getstatic Test/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/d I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

aload_0
invokevirtual List/getSize()I
    putstatic Test/d I
    ldc "Val "
    getstatic Test/d I

    getstatic     java/lang/System/out Ljava/io/PrintStream; 
    new       java/lang/StringBuilder 
    dup 
    ldc "Val "
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    getstatic Test/d I
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


return
.limit locals 32
.limit stack 32
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
