var today=new Date();
var time=today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
var data = [
  { x: time, a: 22},
  { x: time, a: 26},
  { x: time, a: 24},
  { x: time, a: 27},
  { x: time, a: 25}
],
config = {
  parseTime: false,
  data: data,
  xkey: 'x',
  ykeys: ['a'],
  labels: ['Total Income'],
  fillOpacity: 0.6,
  hideHover: 'auto',
  behaveLikeLine: true,
  resize: true,
  pointFillColors: ['white'],
  pointStrokeColors: ['white'],
  lineColors: ['white','red'],
};

config.xkey.lineColors = "white";
document.fgColor = "black";
time.fgColor = "white";

/* config.element = 'area-chart';
Morris.Area(config); */
config.element = 'line-chart';
Morris.Line(config);
/* config.element = 'bar-chart';
Morris.Bar(config);
config.element = 'stacked';
config.stacked = true;
Morris.Bar(config);
Morris.Donut({
  element: 'pie-chart',
  data: [
    {label: "Friends", value: 30},
    {label: "Allies", value: 15},
    {label: "Enemies", value: 45},
    {label: "Neutral", value: 10}
  ]
}); */