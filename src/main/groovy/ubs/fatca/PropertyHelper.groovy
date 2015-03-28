package ubs.fatca
/**
 * Created by saeidreza on 28/03/15.
 */
class PropertyHelper {
    static String loadProperty(String name, String fromResource) throws IOException {
        Properties props = new Properties()
        props.load(PropertyHelper.class.getResourceAsStream(fromResource))
        props.getProperty(name)
    }
}
