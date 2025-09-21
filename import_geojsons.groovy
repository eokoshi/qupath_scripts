import qupath.lib.geojson.*
import qupath.lib.objects.PathObjects
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.objects.PathObject
import qupath.lib.objects.classes.PathClassFactory

clearAllObjects()

def ROIFolder = buildFilePath(PROJECT_BASE_DIR, "roi")
def annotationFolder = buildFilePath(PROJECT_BASE_DIR, "annotations")

// Get the name of the current image
def imageName = getCurrentImageNameWithoutExtension()

// Construct the path to the GeoJSON file for the current image
def roi_path = buildFilePath(ROIFolder, "roi_" + imageName + ".geojson")
def ann_path = buildFilePath(annotationFolder, imageName + ".geojson")
   
// Check if the GeoJSON file exists
if (new File(ann_path).exists()) {
    print imageName
    def roi = PathIO.readObjects(new File(roi_path))
    addObjects(roi)
    selectAnnotations()
    classifySelected("ROI")
    resetSelection()
    
    def anns = PathIO.readObjects(new File(ann_path))
    addObjects(anns)
    selectObjects(anns)
    classifySelected("annotation")
    resetSelection()
} else {
    println "GeoJSON file not found for image: $imageName"
}