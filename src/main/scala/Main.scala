import com.dslplatform.client.Bootstrap
import com.dslplatform.test.my.A
import com.dslplatform.test.my.repositories.ARepository

object Main extends App {

  val locator = Bootstrap.init(getClass.getClassLoader.getResourceAsStream("project.props"))

  val arep = locator.resolve(classOf[ARepository])

  arep.insert(new A())
  arep.insert(new A())
  arep.insert(new A())
  arep.insert(new A())

  arep.findAll().get().toArray.foreach({
    a =>
      println(a)
  })




}

