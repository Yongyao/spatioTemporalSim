package stc.spatioTemporalSim.Similarity;

import stc.spatioTemporalSim.time.Time;

public class TempSimModel {
  Time t1;
  Time t2;

  public TempSimModel(Time start, Time end) {
    this.t1 = start;
    this.t2 = end;
  }

  public long getOverlapTime() {
    long overlap = Math.min(t1.getEnd(), t2.getEnd()) - Math.max(t1.getStart(), t2.getStart());
    return Math.max(0, overlap);
  }

  public long getUnionTime() {
    Time t = new Time(Math.min(t1.getStart(), t2.getStart()),
                    Math.max(t1.getEnd(), t2.getEnd()));
    return t.getLength();
  }

  public double getSimilarity() {
    double sim = 0.0;
    long length1 = t1.getLength();
    long length2 = t2.getLength();
    long overlap = getOverlapTime();

    if ( length1> 0 && length2 > 0) {
      sim = overlap * 0.5 / length1 + overlap * 0.5 / length2;
    }
    return sim;
  }

  public static void main(String[] args) {
    Time t1 = new Time(18, 30);
    Time t2 = new Time(15, 20);

    TempSimModel tempSimModel = new TempSimModel(t1, t2);
    double sim = tempSimModel.getSimilarity();
    System.out.println(sim);
  }
}
