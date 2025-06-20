import qupath.lib.geojson.*
import qupath.lib.objects.PathObjects
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.objects.PathObject
import qupath.lib.objects.classes.PathClassFactory

def geojsonFolder = 'C:/Users/ethan/Downloads/ROSE-AI/contours'

// Get the name of the current image
def imageName = getCurrentImageNameWithoutExtension()

// Construct the path to the GeoJSON file for the current image
def geojsonFilePath = buildFilePath(geojsonFolder, "cnt_" + imageName + ".geojson")
   
print geojsonFilePath
// Check if the GeoJSON file exists
if (new File(geojsonFilePath).exists()) {
    def pathObjects = PathIO.readObjects(new File(geojsonFilePath))
        
    addObjects(pathObjects)
} else {
    println "GeoJSON file not found for image: $imageName"
}