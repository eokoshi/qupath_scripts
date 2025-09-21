import qupath.lib.geojson.*
import qupath.lib.objects.PathObjects
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.objects.PathObject
import qupath.lib.objects.classes.PathClassFactory


def ROIFolder = buildFilePath(PROJECT_BASE_DIR, "roi")
def annotationFolder = buildFilePath(PROJECT_BASE_DIR, "annotations")
mkdirs(ROIFolder)
mkdirs(annotationFolder)

// Get the name of the current image
def imageName = getCurrentImageNameWithoutExtension()

// Construct the path to the GeoJSON file for the current image
def roi_path = buildFilePath(ROIFolder, "roi_" + imageName + ".geojson")
def ann_path = buildFilePath(annotationFolder, imageName + ".geojson")

selectObjectsByClassification("ROI")
exportSelectedObjectsToGeoJson(roi_path)
resetSelection()

selectObjectsByClassification("annotation")
exportSelectedObjectsToGeoJson(ann_path)
resetSelection()