public class OHRequestComparator implements Comparator<OHRequest> {
    @Override
    public int compare(OHRequest s1, OHRequest s2) {
        boolean s1DescMatchesSetup = s1.description.equals("setup");
        boolean s2DescMatchesSetup = s2.description.equals("setup");

        if (s1.isSetup && !s2.isSetup) {
            return -1;
        } else if (!s1.isSetup && s2.isSetup) {
            return 1;
        } else if (s1DescMatchesSetup && !s2DescMatchesSetup) {
            return -1;
        } else if (!s1DescMatchesSetup && s2DescMatchesSetup) {
            return 1;
        }
        return 0;
    }
}
