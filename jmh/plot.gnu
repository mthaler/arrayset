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

set terminal pngcairo size 800, 1200
set output "setcreate.png"
set multiplot layout 2,1

set title "create bulk"
bench = "c.m.a.b.create.SetCreateBench.createBulk"

plot file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "arrayset")? $7:1/0) with linespoints title "arrayset" ls 1, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "hashset")? $7:1/0) with linespoints title "hashset" ls 2, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "sortedset")? $7:1/0) with linespoints title "sortedset" ls 3

set title "create elementwise"
bench = "c.m.a.b.create.SetCreateBench.createElements"

plot file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "arrayset")? $7:1/0) with linespoints title "arrayset" ls 1, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "hashset")? $7:1/0) with linespoints title "hashset" ls 2, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "sortedset")? $7:1/0) with linespoints title "sortedset" ls 3

unset multiplot
     
set terminal pngcairo size 800, 1200
set output "setelement.png"
set multiplot layout 2,1

set title "contains true"
bench = "c.m.a.b.element.SetElementBench.containsTrue"

plot file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "arrayset")? $7:1/0) with linespoints title "arrayset" ls 1, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "hashset")? $7:1/0) with linespoints title "hashset" ls 2, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "sortedset")? $7:1/0) with linespoints title "sortedset" ls 3
     
set title "contains false"
bench = "c.m.a.b.element.SetElementBench.containsFalse"

plot file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "arrayset")? $7:1/0) with linespoints title "arrayset" ls 1, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "hashset")? $7:1/0) with linespoints title "hashset" ls 2, \
     file using 4:((stringcolumn(1) eq bench) && (stringcolumn(2) eq "sortedset")? $7:1/0) with linespoints title "sortedset" ls 3
     
unset multiplot
