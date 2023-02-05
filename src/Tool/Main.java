package Tool;

/**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注意：目前 Java 代码的入口类名称必须为 Main（大小写敏感）
 1、本框架是一个轻量级非侵入的java校验框架，主要通过注解方式实现对类的校验,开箱即用，扩展性高

 2、使用方式主要通过在类的属性加上校验注解，调用 ValidateUtils.check(object) 就可以对对象进行校验，
 校验内容为，每个属性上加入的校验注解，一个属性可以加多个校验注解，如，提供的测试用例中的学生类Student 见代码134行

 // @NotNull非空校验注解，校验框架会对 name字段进行非空校验
 //msg 为校验失败的自定义异常信息
 @NotNull(msg = "学生姓名不能为空")
 private String name;

 //@Min@Max，最小值最大值注解，校验框架会对 age字段进行  大于6 小于12的校验
 //value 为校验的最大值、最小值，校验框架会拿属性的值与value值进行对比
 //msg 为校验失败的自定义异常信息
 @Min(value = 6,msg = "小学生的最小岁数为6岁")
 @Max(value = 12,msg = "小学生的最大岁数为12岁")
 private int age;

 //@MinLength最小长度注解，校验框架会对 studentNo字段进行长度校验，判断长度是否大于6
 //value 为校验的最小长度，校验框架会拿属性的值长度与value值进行对比
 //msg 为校验失败的自定义异常信息
 @MinLength(value = 6,msg = "小学生的学号都是6位以上")
 private String studentNo;

 //@Regex正则表达式注解，校验框架会对 email字段进行正则表达式校验，判断是否合法,正则表达式为  [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+
 //value 为校验的正则表达式，校验框架会拿属性的值进行正则表达式校验
 //msg 为校验失败的自定义异常信息
 @Regex(value = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+",msg = "小学生的邮件校验失败")
 private String email;

 3.调用 ValidateUtils.check(object) 校验是，如果校验失败会跑出一个ValidateException异常，没有抛出异常说明校验通过

 4.整个框架通过注解接入使用，非侵入性，开箱即用，已经默认实现了常用的参数校验方式，支持正则表达式校验，用户可以自定义校验正则表达式

 5.整个框架不依赖与第三方jar包，体积小，轻量级

 6.框架扩展性高：
 6.1 新的校验方式 只需要加入新的注解，在ValidateUtils中实现具体的校验方式，如一些场景需要调用rpc服务等方式进校验
 6.2 校验失败返回的异常信息，包括 code、msg用户在使用都可以自定义，以最大程度契合业务代码的校验

 */

/**
 * @author Justice_wby
 * @create 2023-02-03 1:25
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 用例1: 小学生对象的年龄有问题
         * @Min(value = 6,msg = "小学生的最小岁数为6岁")
         * @Max(value = 12,msg = "小学生的最大岁数为12岁")
         * private int age;
         * 注解规定，小学生的最小岁数为6岁，小学生的最大岁数为12岁
         * 校验框架会对 age字段进行  大于6 小于12的校验
         */
        Student student = new Student();
        student.setAge(2);
        student.setStudentNo("abcdefg");
        student.setName("测试小学生");
        student.setEmail("1123154@163.com");
        try {
            ValidateUtils.check(student);
        } catch (Exception e) {
            System.out.println(e);
        }

        /**
         * 用例2: 小学生的姓名为空
         * @NotNull(msg = "学生姓名不能为空")
         * private String name;
         * 注解规定，学生姓名不能为空
         * 校验框架会对 name字段进行非空校验
         */
        Student student1 = new Student();
        student1.setAge(7);
        student1.setStudentNo("abcdefg");
        student1.setName("");
        student1.setEmail("1123154@163.com");
        try {
            ValidateUtils.check(student1);
        } catch (Exception e) {
            System.out.println(e);
        }

        /**
         * 用例3: 小学生的学号有问题
         * @MinLength(value = 6,msg = "小学生的学号都是6位以上")
         * private String studentNo;
         * 注解规定，小学生的学号都是6位以上
         * 校验框架会对 studentNo字段进行长度校验，判断长度是否大于6
         */
        Student student2 = new Student();
        student2.setAge(7);
        student2.setStudentNo("abcde");
        student2.setName("测试小学生");
        student2.setEmail("1123154@163.com");
        try {
            ValidateUtils.check(student2);
        } catch (Exception e) {
            System.out.println(e);
        }

        /**
         * 用例4: 小学生的邮箱有问题
         * @Regex(value = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+",msg = "小学生的邮件校验失败")
         * private String email;
         * 注解规定，会对小学生的邮箱进行[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+
         * 正则表达式校验
         * 校验框架会对 email字段进行正则表达式校验，判断是否合法
         */
        Student student3 = new Student();
        student3.setAge(7);
        student3.setStudentNo("abcdefg");
        student3.setName("测试小学生");
        student3.setEmail("1123154@1");
        try {
            ValidateUtils.check(student3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/**
 * 创建个学生类，用来测试注解型的校验框架
 在需要校验的属性上加上校验注解
 */
class Student{
    // @NotNull非空校验注解，校验框架会对 name字段进行非空校验
    //msg 为校验失败的自定义异常信息
    @NotNull(msg = "学生姓名不能为空")
    private String name;

    //@Min@Max，最小值最大值注解，校验框架会对 age字段进行  大于6 小于12的校验
    //value 为校验的最大值、最小值，校验框架会拿属性的值与value值进行对比
    //msg 为校验失败的自定义异常信息
    @Min(value = 6,msg = "小学生的最小岁数为6岁")
    @Max(value = 12,msg = "小学生的最大岁数为12岁")
    private int age;

    //@MinLength最小长度注解，校验框架会对 studentNo字段进行长度校验，判断长度是否大于6
    //value 为校验的最小长度，校验框架会拿属性的值长度与value值进行对比
    //msg 为校验失败的自定义异常信息
    @MinLength(value = 6,msg = "小学生的学号都是6位以上")
    private String studentNo;

    //@Regex正则表达式注解，校验框架会对 email字段进行正则表达式校验，判断是否合法,正则表达式为  [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+
    //value 为校验的正则表达式，校验框架会拿属性的值进行正则表达式校验
    //msg 为校验失败的自定义异常信息
    @Regex(value = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+",msg = "小学生的邮件校验失败")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/**
 * 最大值校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface Max {
    /**
     * 设置最大值，要校验的值不能要小于该值
     */
    int value();

    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 最大长度校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface MaxLength {
    /**
     * 设置最大长度，要校验的值的长度不能要小于该值
     */
    int value();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 最小值校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface Min {
    /**
     * 设置最小值，要校验的值不能要大于该值
     */
    int value();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 最小长度校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface MinLength {
    /**
     * 设置最小长度，要校验的值的长度不能要大于该值
     */
    int value();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 不为空校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface NotNull {
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 正则表达式校验
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface Regex {
    /**
     *  设置一个正则表达，通过正则表达式校验
     */
    String value();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}

/**
 * 日期校验，校验日期是否为该格式
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface Date {
    /**
     * 校验日期的格式
     */
    String format();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}
/**
 * 范围校验，判断值是否在校验值中间
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@interface in {
    /**
     * 校验范围
     */
    String value();

    /**
     * 范围值的分隔符
     * @return
     */
    String split();
    /**
     * 用户自定义异常描述
     */
    String msg() default "";
}


/**
 * 校验参数异常，继承RuntimeException异常，当校验参数失败后跑出异常
 */
class ValidateException extends RuntimeException {
    /**
     * 异常信息msg
     */
    private String msg;

    /**
     * 具体异常码
     */
    private Integer code;


    public ValidateException() {
        super();
    }

    public ValidateException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ValidateException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public ValidateException(String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.msg = String.format(msgFormat, args);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(String message) {
        this.code = -1;
    }


    public String getMsg() {
        return msg;
    }


    public Integer getCode() {
        return code;
    }

    /**
     * 追加msg
     *
     * @param msg
     */
    public ValidateException appendMsg(String msg) {
        return new ValidateException(-1, this.msg + msg);
    }

    @Override
    public String toString() {
        return "ValidateException{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}

class ValidateUtils {



    /**
     * 对象校验（通过注解）
     *
     * @param value 校验对象
     * @return ValidateUtils
     */
    public static void check(Object value) {
        //先校验传入对象是否为空
        ValidateHandler.notNull(value, "");
        //获取对象的class,来反射获取对象的所有属性
        Class classType = value.getClass();
        Set<Field> fieldSet = ReflectUtils.getFieldsByClass(classType);

        //校验对象的字段是否为空，如果没空，则不需要校验
        if (fieldSet == null){
            return;
        }


        //遍历每个属性，获取属性上的注解，进行具体的校验
        for (Field field : fieldSet) {
            //对应属性的值
            Object fieldValue;
            try {
                //获取校验对象该属性的值
                fieldValue = ReflectUtils.getFieldValueByName(value, field.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //获取字段上注解，根据注解进行校验
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                //遍历判断，字段上的注解是哪个，进行具体的处理方法进行检验
                if (annotation instanceof NotNull) {
                    ValidateHandler.notNull(fieldValue, ((NotNull) annotation).msg());
                } else if (annotation instanceof Max) {
                    Max max = (Max) annotation;
                    ValidateHandler.max(max.value(), fieldValue, max.msg());
                } else if (annotation instanceof Min) {
                    Min min = (Min) annotation;
                    ValidateHandler.min(min.value(), fieldValue, min.msg());
                } else if (annotation instanceof MaxLength) {
                    MaxLength maxLength = (MaxLength) annotation;
                    ValidateHandler.maxLength(maxLength.value(), fieldValue, maxLength.msg());
                } else if (annotation instanceof MinLength) {
                    MinLength minLength = (MinLength) annotation;
                    ValidateHandler.minLength(minLength.value(), fieldValue, minLength.msg());
                } else if (annotation instanceof Regex) {
                    Regex regex = (Regex) annotation;
                    ValidateHandler.regex(regex.value(), fieldValue, regex.msg());
                } else if (annotation instanceof Date) {
                    Date date = (Date) annotation;
                    String format = date.format();
                    ValidateHandler.date(format, fieldValue, date.msg());
                }
            }
        }

    }

}

/**
 * 参数校验处理类
 */
class ValidateHandler {


    /**
     * 校验参数是否为空
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param value 参数
     * @param msg   错误信息
     */
    public static void notNull(Object value, String msg) {
        try {
            notNull(value);
            if (value instanceof String) {
                notNull((String) value);
            } else if (value instanceof Number) {
                notNull((Number) value);
            } else if (value instanceof Collection) {
                notNull((Collection) value);
            } else if (value instanceof Map) {
                notNull((Map) value);
            } else if (value instanceof Object[]) {
                notNull((Object[]) value);
            } else if (value instanceof List) {
                notNull((List) value);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 正则表达式检验
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param regex 正则表达式
     * @param value 参数
     * @param msg   错误信息
     */
    public static void regex(String regex, Object value, String msg) {
        try {
            if (null == value) {
                return;
            }
            regex(regex, value.toString());
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 校验参数最大值
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param max   最大值
     * @param value 参数
     * @param msg   错误信息
     */
    public static void max(Number max, Object value, String msg) {
        try {
            if (null == value || !(value instanceof Number)) {
                return;
            }
            if (value instanceof Integer) {
                max(max.intValue(), (Integer) value);
            } else if (value instanceof Long) {
                max(max.longValue(), (Long) value);
            } else if (value instanceof Double) {
                max(max.doubleValue(), (Double) value);
            } else if (value instanceof Float) {
                max(max.floatValue(), (Float) value);
            } else if (value instanceof Short) {
                max(max.shortValue(), (Short) value);
            } else if (value instanceof Byte) {
                max(max.byteValue(), (Byte) value);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 校验参数最大长度
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param max   最大长度
     * @param value 参数
     * @param msg   错误信息
     */
    public static void maxLength(int max, Object value, String msg) {
        try {
            if (null == value) {
                return;
            }
            if (value instanceof String) {
                maxLength(max, (String) value);
            } else if (value instanceof Collection) {
                maxLength(max, (Collection) value);
            } else if (value instanceof Map) {
                maxLength(max, (Map) value);
            } else if (value instanceof Object[]) {
                maxLength(max, (Object[]) value);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 校验参数最小长度
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param min   参数最小长度
     * @param value 参数
     * @param msg   错误信息
     */
    public static void minLength(int min, Object value, String msg) {
        try {
            if (null == value) {
                return;
            }
            if (value instanceof String) {
                minLength(min, (String) value);
            } else if (value instanceof Collection) {
                minLength(min, (Collection) value);
            } else if (value instanceof Map) {
                minLength(min, (Map) value);
            } else if (value instanceof Object[]) {
                minLength(min, (Object[]) value);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 校验参数最小值
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param min   最小值
     * @param value 参数
     * @param msg   错误信息
     */
    public static void min(Number min, Object value, String msg) {
        try {
            if (null == value || !(value instanceof Number)) {
                return;
            }
            if (value instanceof Integer) {
                min(min.intValue(), (Integer) value);
            } else if (value instanceof Long) {
                min(min.longValue(), (Long) value);
            } else if (value instanceof Double) {
                min(min.doubleValue(), (Double) value);
            } else if (value instanceof Float) {
                min(min.floatValue(), (Float) value);
            } else if (value instanceof Short) {
                min(min.shortValue(), (Short) value);
            } else if (value instanceof Byte) {
                min(min.byteValue(), (Byte) value);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }


    /**
     * 校验日期型参数
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param format 日期格式
     * @param value  日期参数
     * @param msg    错误信息
     */
    public static void date(String format, Object value, String msg) {
        try {
            if (null != value) {
                date(format, value.toString());
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 校验参数in
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param in    in范围
     * @param value 要检验的值
     * @param split 分隔符
     * @param msg   错误信息
     */
    public static void in(String in, String value, String split, String msg) {
        try {
            if (null != value) {
                in(in, value, split);
            }
        } catch (ValidateException e) {
            errorMsgHandler(e, msg);
        }
    }

    /**
     * 如果msg为空，返回默认定义的异常，
     * 如果msg不为空，则在默认异常说明上追加用户自己新定义的异常说明
     *
     * @param e   默认定义的异常
     * @param msg 用户自己新定义的异常说明
     */
    private static void errorMsgHandler(ValidateException e, String msg) {
        if (CommonUtils.isNull(msg)) {
            throw e;
        }
        throw e.appendMsg(msg);
    }


    /**
     * 判断参数是否为空
     *
     * @param value 参数
     */
    private static void notNull(Object value) {
        if (null == value) {
            throw new ValidateException("参数不能为空！");
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param value 参数
     */
    private static void notNull(String value) {
        if (CommonUtils.isNull(value)) {
            throw new ValidateException("参数不能为空！");
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param number 参数
     */
    private static void notNull(Number number) {
        if (null == number) {
            throw new ValidateException("参数不能为空！");
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param value 参数
     */
    private static void notNull(Collection value) {
        if (CommonUtils.isNull(value)) {
            throw new ValidateException("参数不能为空！");
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param value 参数
     */
    private static void notNull(Map value) {
        if (CommonUtils.isNull(value)) {
            throw new ValidateException("参数不能为空！");
        }
    }

    /**
     * 判断参数是否为空
     *
     * @param value 参数
     */
    private static void notNull(Object[] value) {
        if (CommonUtils.isNull(value)) {
            throw new ValidateException("参数不能为空！");
        }
    }


    /**
     * 参数正则校验
     *
     * @param regex 正则表达式
     * @param value 参数
     */
    private static void regex(String regex, String value) {
        if (null != value) {
            if (!RegexUtils.regex(regex, value)) {
                throw new ValidateException("正则表达式校验异常！正则表达式为%s,要校验的值为%s", regex, value);
            }
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(int max, int value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(long max, long value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(float max, float value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(double max, double value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(byte max, byte value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大值
     *
     * @param max   最大值
     * @param value 参数
     */
    private static void max(short max, short value) {
        if (value > max) {
            throw new ValidateException("要校验的值为%s,大于规定的最大值%s", value, max);
        }
    }

    /**
     * 校验参数最大长度
     *
     * @param max   最大长度
     * @param value 字符串数据
     */
    private static void maxLength(int max, String value) {
        if (!CommonUtils.isNull(value)) {
            if (value.length() > max) {
                throw new ValidateException("要校验的值为%s,值的长度大于规定的最大值%s", value, max);
            }
        }
    }

    /**
     * 校验参数最大长度
     *
     * @param max   最大长度
     * @param value 集合参数
     */
    private static void maxLength(int max, Collection value) {
        if (null != value) {
            if (value.size() > max) {
                throw new ValidateException("要校验的值为%s,值的长度大于规定的最大值%s", value, max);
            }
        }
    }

    /**
     * 校验参数最大长度
     *
     * @param max   最大长度
     * @param value map型参数
     */
    private static void maxLength(int max, Map value) {
        if (null != value) {
            if (value.size() > max) {
                throw new ValidateException("要校验的值为%s,值的长度大于规定的最大值%s", value, max);
            }
        }
    }

    /**
     * 校验参数最大长度
     *
     * @param max   最大长度
     * @param value 数组型参数
     */
    private static void maxLength(int max, Object[] value) {
        if (null != value) {
            if (value.length > max) {
                throw new ValidateException("要校验的值为%s,值的长度大于规定的最大值%s", value, max);
            }
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value int型参数
     */
    private static void min(int min, int value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value long型数据
     */
    private static void min(long min, long value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value float型数据
     */
    private static void min(float min, float value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value double型参数
     */
    private static void min(double min, double value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value byte型参数
     */
    private static void min(byte min, byte value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小值
     *
     * @param min   最小值
     * @param value short型参数
     */
    private static void min(short min, short value) {
        if (value < min) {
            throw new ValidateException("要校验的值为%s,小于规定的最小值%s", value, min);
        }
    }

    /**
     * 校验参数最小长度
     *
     * @param min   最小长度
     * @param value 字符串型参数
     */
    private static void minLength(int min, String value) {
        if (!CommonUtils.isNull(value)) {
            if (value.length() < min) {
                throw new ValidateException("要校验的值为%s,值的长度小于规定的最小值%s", value, min);
            }
        }
    }

    /**
     * 校验参数最小长度
     *
     * @param min   最小长度
     * @param value 集合型数据
     */
    private static void minLength(int min, Collection value) {
        if (null != value) {
            if (value.size() < min) {
                throw new ValidateException("要校验的值为%s,值的长度小于规定的最小值%s", value, min);
            }
        }
    }

    /**
     * 校验参数最小长度
     *
     * @param min   最小长度
     * @param value map型数据
     */
    private static void minLength(int min, Map value) {
        if (null != value) {
            if (value.size() < min) {
                throw new ValidateException("要校验的值为%s,值的长度小于规定的最小值%s", value, min);
            }
        }
    }

    /**
     * 校验参数最小长度
     *
     * @param min   最小长度
     * @param value 数组型参数
     */
    private static void minLength(int min, Object[] value) {
        if (null != value) {
            if (value.length < min) {
                throw new ValidateException("要校验的值为%s,值的长度小于规定的最小值%s", value, min);
            }
        }
    }

    /**
     * 校验参数日期格式
     *
     * @param format 日期格式
     * @param value  日期型参数
     */
    private static void date(String format, String value) {
        if (!CommonUtils.isNull(value)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            try {
                simpleDateFormat.parse(value);
            } catch (Exception e) {
                throw new ValidateException("校验失败，要校验日期为%s,要求的日期格式为%s", value, format);
            }
        }
    }

    /**
     * 参数in形式的校验
     *
     * @param in    in的范围
     * @param value 要校验的值
     * @param split 分割符
     */
    private static void in(String in, String value, String split) {
        if (CommonUtils.isNull(in) || CommonUtils.isNull(value)) {
            throw new ValidateException("校验失败，校验的值为%s,判断值是否在%s范围内，范围分割符为%s", value, in, split);
        }

        try {
            String[] array = in.split(split);
            List<String> list = Arrays.asList(array);

            if (!list.contains(value)) {
                throw new ValidateException("校验失败，校验的值为%s,判断值是否在%s范围内，范围分割符为%s", value, in, split);
            }
        } catch (Exception e) {
            throw new ValidateException("校验失败，校验的值为%s,判断值是否在%s范围内，范围分割符为%s", value, in, split);
        }
    }

}

/**
 * 正则表达式校验工具
 */
class RegexUtils {

    public static boolean regex(String regex, String value) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);
        return m.matches();
    }
}

class CommonUtils {

    public static boolean isNull(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNull(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNull(Map<?, ?> paramMap) {
        return null == paramMap || paramMap.isEmpty();
    }

    public static boolean isNull(Object[] array) {
        return null == array || array.length == 0;
    }
}


/**
 * 反射工具
 */
class ReflectUtils {


    //使用一个本地缓存map，避免多次反射带来的性能开销
    private static Map<Class, Set<Field>> classFieldSetMap;

    static {
        classFieldSetMap = new HashMap<>();
    }

    /**
     * 获取类的一个类的所有字段
     *
     * @param cls
     * @return
     */
    public static Set<Field> getFieldsByClass(Class cls) {

        //先通过Class 从本地缓存中获取对象的所有数据，
        Set<Field> fieldsCache = classFieldSetMap.get(cls);
        if (fieldsCache != null) {
            return fieldsCache;
        }

        //缓存中没有，在通过反射获取，获取到存储到缓存map中
        Set<Field> fieldSet = new HashSet<>();
        for (Class<?> clazz = cls; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if (CommonUtils.isNull(fields)) {
                continue;
            }
            for (Field field : fields) {
                if (!field.getName().equals("class") && !field.getName().equals("serialVersionUID")) {
                    fieldSet.add(field);
                }
            }
        }

        //存储到缓存中
        classFieldSetMap.put(cls, fieldSet);
        return fieldSet;
    }

    /**
     * 获取目标值的 fieldName 对象值
     *
     * @param o         目标对象
     * @param fieldName 字段名
     * @return
     */
    public static Object getFieldValueByName(Object o, String fieldName) {

        if (fieldName == null) {
            return null;
        }
        try {
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            //从origin中拿到该值
            Method getMethodOrigin = o.getClass().getMethod("get" + fieldName);
            return getMethodOrigin.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
