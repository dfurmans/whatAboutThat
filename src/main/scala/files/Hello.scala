package files

case class Configuration(path: os.Path = os.home)
object Configuration {
  val aLinuxPathSeparator = "/"
  val fileExtension = "txt" 
  def apply(path: String) = new Configuration(os.Path(path)) 
}

object FileNamesChangesFunctions{
    val functionToCapitalizeFileName : String => String = aName => {
      aName.toUpperCase
    }
    // add you desired file name change function
}

object Hello extends App {

  import FileNamesChangesFunctions._
  val paths            = os.list(Configuration(os.pwd).path)
  val allCanoniclaPath = paths.map(aPath => aPath.toString.split(Configuration.aLinuxPathSeparator))
  val onlyNames        = allCanoniclaPath.map(aFileOrDir => aFileOrDir.last)
  val onlyTxtFileNames = onlyNames.filter(fileName => fileName.contains(Configuration.fileExtension))

  val myDesiredChange  = onlyTxtFileNames.map(x => functionToCapitalizeFileName(x) )
  println(" My new file names => " + myDesiredChange)

  // TODO save new filesnames into FS

}

