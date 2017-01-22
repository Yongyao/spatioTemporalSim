package stc.spatioTemporalSim.time;

public class Time {
  long start;
  long end;

  public Time(long start, long end) {
    this.start = start;
    this.end = end;
  }

  public long getLength() {
    return this.end - this.start;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public long getEnd() {
    return end;
  }

  public void setEnd(long end) {
    this.end = end;
  }
}
