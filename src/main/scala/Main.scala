import java.util.concurrent.ExecutorService

import com.dslplatform.client.{AnyTransport, HttpClientTransport, HttpTransport, Bootstrap}
import com.dslplatform.patterns.ServiceLocator
import com.dslplatform.test.my.A
import com.dslplatform.test.my.repositories.ARepository


object Main extends App {
  import Regular._
  dosome(makeAnyLocator)
  println("Did some!")
}

object Regular {

  def makeURLocator = {
    Bootstrap.init(getClass.getClassLoader.getResourceAsStream("project.props"))
  }

  def makeApacheLocator  = {
    val initialComponents: java.util.Map[Class[_], Object] = new java.util.HashMap[Class[_], Object]()
    initialComponents.put(classOf[HttpTransport], classOf[HttpClientTransport])
    val locator = Bootstrap.init(getClass.getClassLoader.getResourceAsStream("project.props"), initialComponents)
    locator
  }

  def makeAnyLocator = {
    val initialComponents: java.util.Map[Class[_], Object] = new java.util.HashMap[Class[_], Object]()
    initialComponents.put(classOf[HttpTransport], classOf[AnyTransport])
    val locator = Bootstrap.init(getClass.getClassLoader.getResourceAsStream("projectAny.props"), initialComponents)
    locator
  }

  def dosome(locator: ServiceLocator) {

    val a1: A = new A()

    val arep = locator.resolve(classOf[ARepository])
    arep.insert(a1).get()

    arep.findAll().get().toArray.foreach(println)

    locator.resolve(classOf[ExecutorService]).shutdown()
  }
}