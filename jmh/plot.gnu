set datafile separator comma
set terminal png
set logscale x
set logscale y
set xlabel "N"
set ylabel "ns"
set style line 1 lt rgb "green"
set style line 2 lt rgb "red"
set style line 3 lt rgb "blue"
set key left top
set format "%'.0f"

file = "results.txt"
set terminal png size 800, 1200
set output "setcreate.png"
set multiplot layout 2,1
set title "create bulk"
bench = "c.m.a.b.create.SetCreateBench.createBulk"
plot \
  file using 9:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 9:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 9:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "create elementwise"
bench = "c.m.a.b.create.SetCreateBench.createElements"
plot \
  file using 9:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 9:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 9:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3
unset multiplot

file = "results.txt"
set terminal png size 800, 1200
set output "setelement.png"
set multiplot layout 2,1

set title "contains true"
bench = "c.m.a.b.element.SetElementBench.containsTrue"
plot \
  file using 9:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 9:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 9:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "contains false"
bench = "c.m.a.b.element.SetElementBench.containsFalse"
plot \
  file using 9:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 9:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 9:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3
unset multiplot

file = "results.txt"
set terminal png size 800, 2400
set output "setset.png"
set multiplot layout 4,1
set title "union"
bench = "c.m.a.b.set.SetSetBench.union"
plot \
  file using 10:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 10:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 10:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "intersect"
bench = "c.m.a.b.set.SetSetBench.intersect"
plot \
  file using 10:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 10:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 10:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "diff"
bench = "c.m.a.b.set.SetSetBench.diff "
plot \
  file using 10:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 10:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 10:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "filter"
bench = "c.m.a.b.set.SetSetBench.filter"
plot \
  file using 10:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 10:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 10:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3

set title "subsetOf"
bench = "c.m.a.b.set.SetSetBench.subsetOf"
plot \
  file using 10:((stringcolumn(8) eq "arrayset")  && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "arrayset" ls 1, \
  file using 10:((stringcolumn(8) eq "hashset")   && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "hashset" ls 2, \
  file using 10:((stringcolumn(8) eq "sortedset") && (stringcolumn(1) eq bench)? $5:1/0) with linespoints title "sortedset" ls 3
unset multiplot
