package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class hello {
    /**
     * 使用@Usage 注解解释该命令的用途。
     * 使用@Command 注解当前是一个CRaSH 命令。
     * 获得Spring Boot 的版本，注意Groovy 的方法和变量声明关键字为def.
     * 获得Spring 框架的版本。
     * 返回命令执行结果。
     */
    @Usage("Say Hello")
    @Command
    def main(InvocationContext context) {

        def bootVersion = context.attributes['spring.boot.version'];
        def springVersion = context.attributes['spring.version']

        return "Hello,your Spring Boot version is " + bootVersion + ",your Spring Framework version is " + springVersion

    }
}