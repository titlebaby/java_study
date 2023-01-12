## 注解
### springboot自动装配原理
```java

Properties properties = PropertiesLoaderUtils.loadProperties(resource);
//所有资源加载到配置类中
```
结论:
   springboot所有自动配置都是在启动的时候扫描并加载，spring.factories所有的自动配置类都在这里面，但是不一定生效，要判断条件是否成立，只要导入了对应的start，就有对应的启动器了，有了启动器，我们自动装配就会生效，然后就配置成功！
1. springboot在启动的时候，从类路径下/META-INF/spring.factories获取指定的值
2. 将这些自动配置的类导入容器，自动配置就会生效，帮我进行自动配置！
3. 以前我们需要自动配置的东西，现在springboot帮我们做了
4. 整合javaEE，解决方案和自动配置的东西都在 spring-boot-autoconfigiure-2.2.0.RELEASE.jar这个包下
5. 它会把所有需要导入的组件，以类名的方式返回，这些组件就会被添加到容器
6. 容器中也会存在非常多的xxxAutoConfiguration的文件（@Bean）就是这些类给容器中导入了这个场景需要的所有组件；并自动配置，@configuration，javaconfig

## SpringApplication
这个类主要做了一下四件事情
1. 推断应用的类型是普通的项目还是web项目
2. 查找并加载所有可用的初始化器，设置到initializers属性中
3. 找出多有的应用程序监听器，设置到listeners属性中
4. 推断并设置main方法的定义类，找到运行的主类

### 自动装配的原理
总结：

1. springboot启动会加载大量的自动配置类。
2. 我们看我们需要的功能有没有在springboot默认写好的自动配置类中；
3. 我们再来看这个自动配置类中，到底配置了哪些组件，（只要我们要用的组件存在其中，我们就不需要在手动配置了）
4. 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；

xxxAutoConfiguration ： 自动配置类； 给容器中添加组件
xxxProperties ： 封装配置文件中相关属性 ，（springboot的配置文件：application.properties ； application.yaml）
