def pathOutput = buildFilePath(PROJECT_BASE_DIR, 'export')
mkdirs(pathOutput)
def imageName = getCurrentImageNameWithoutExtension()
def path = buildFilePath(pathOutput, "cnt_" + imageName + ".geojson")
def annotations = getAnnotationObjects()
// 'FEATURE_COLLECTION' is standard GeoJSON format for multiple objects
exportObjectsToGeoJson(annotations, path, "FEATURE_COLLECTION")