import java.util.concurrent.ExecutorService

import com.dslplatform.client.Bootstrap
import com.dslplatform.test.my.A
import com.dslplatform.test.my.repositories.ARepository


object Main extends App {
  AA.dosome
}

object AA {
  def dosome {
    val a1: A = new A()
    val locator = Bootstrap.init(getClass.getClassLoader.getResourceAsStream("project.props"))

    val arep = locator.resolve(classOf[ARepository])

    arep.insert(a1).get()
    arep.insert(a1).get()
    arep.insert(a1).get()
    arep.insert(a1).get()

    arep.findAll().get().toArray.foreach({
      a =>
        println(a)
    })

    locator.resolve(classOf[ExecutorService]).shutdown()


  }
}