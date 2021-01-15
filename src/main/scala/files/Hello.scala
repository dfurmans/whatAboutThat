// imports library to deal with the files 
package files

// creates a class to deal with paths 
case class Configuration(path: os.Path = os.home)
object Configuration {
  val aLinuxPathSeparator = "/"
  val fileExtension = "txt" 
  // function takes a path and returns a configuration object as a string
  def apply(path: String) = new Configuration(os.Path(path)) 
}

object FileNamesChangesFunctions{
    // takes a string as argument and returns a string which is a capitalized version of input string 
    val functionToCapitalizeFileName : String => String = aName => {
      aName.toUpperCase
    }
    // add you desired file name change function
}

// main program created by using app trait on object Hello
object Hello extends App {
  
  // import some spanners
  import FileNamesChangesFunctions._
  
  // grabs all the paths in the working directory
  val paths            = os.list(Configuration(os.pwd).path)
  val allCanoniclaPath = paths.map(aPath => aPath.toString.split(Configuration.aLinuxPathSeparator))
  val onlyNames        = allCanoniclaPath.map(aFileOrDir => aFileOrDir.last)
  val onlyTxtFileNames = onlyNames.filter(fileName => fileName.contains(Configuration.fileExtension))

  val myDesiredChange  = onlyTxtFileNames.map(x => functionToCapitalizeFileName(x) )
  println(" My new file names => " + myDesiredChange)
   
  print(paths)
    
  // TODO save new filesnames into FS

}

