(

var size = 50;
var start_x = 305;
var x_offset = 20;
var whitenotes_y = 450;
var redCol = Color(1.0, 0.6, 0.5, 1.0);

var basspath = thisProcess.nowExecutingPath.dirname;
var coordinates = CSVFileReader.readInterpret(basspath ++ "/coordinates.pen");
var coordinates2 = CSVFileReader.readInterpret(basspath ++ "/coordinates2.pen");


Window.closeAll;

w = Window.new("tb303", Rect.new(10, 530, 1120, 570))
.front
.alwaysOnTop_(true);

// 1100 * 530
// 1200 * 600

w.drawFunc_{|me|
	// NOTES SECTION BACKDROP
	Color(1.0, 1.0, 1.0, 0.5).setFill;
    Pen.addRect(Rect(28, 300, 1054, 218));
	Pen.fill;

	// some shadows
	Color(0.4, 0.4, 0.4, 0.2).setFill;
    Pen.addRect(Rect(13, 282, 1086, 5));
	Pen.fill;

	// under coat top
	Pen.use {
		var tcoords = [
			[140, 303],[140, 384],[244,384],[244,317],
			[726,317],[726,384],[968,384],[968,360],
			[736,360],[736,303],
		];
		Pen.fillColor = Color(0.3, 0.3, 0.3, 0.9);
		Pen.moveTo(tcoords[0][0]@tcoords[0][1]);
		tcoords.do { |item, idx|
			if (idx > 0) {
				Pen.lineTo(item[0]@item[1]);
			}
		};
		Pen.fill;
	};

	// under coat bottom left
	Pen.use {
		Pen.fillColor = Color(0.3, 0.3, 0.3, 0.9);
		Pen.moveTo(coordinates2[0][0]@coordinates2[0][1]);
		coordinates2.do { |item, idx|
			if (idx > 0) {
				Pen.lineTo(item[0]@item[1]);
			}
		};
		Pen.fill;
	};


	// rightside coat bottom
	Pen.use {
		var tcoords = [
			[847, 466],[967, 466],[967,487],[849,487],[848,485]
		];
		Pen.fillColor = Color(0.3, 0.3, 0.3, 0.9);
		Pen.moveTo(tcoords[0][0]@tcoords[0][1]);
		tcoords.do { |item, idx|
			if (idx > 0) {
				Pen.lineTo(item[0]@item[1]);
			}
		};
		Pen.fill;
	};

	// black keys polygons
	Pen.use {
	    var r = 2;
		var x_i = 0;
		var x_init = 292;
		var y_init = 321;
		var kwidth = 30;
		var kheight = 82;
		var x_offset = 59.5;

		[0,1,3,4,5].do { |item, idx|

			x_i = x_init + (item * x_offset);

			Pen.fillColor = Color(0.3, 0.3, 0.3, 0.9);
		    Pen.moveTo(x_i@y_init);
			Pen.lineTo((x_i + kwidth)@y_init);
			Pen.lineTo((x_i + kwidth)@(y_init + kheight));
		    Pen.lineTo((x_i + kwidth -r)@(y_init + kheight + r));  //    /
			Pen.lineTo((x_i + r)@(y_init + kheight + r));          // \
			Pen.lineTo(x_i@(y_init + kheight));

			Pen.fill;
		}
	};

	// DEL SET
	Pen.use {
	    var r = 2;
		var x_i = 0;
		var x_init = 293;
		var y_init = 491;
		var kwidth = 27;
		var kheight = 12;
		var x_offset = 59.6;

		[0,1].do { |item, idx|

			x_i = x_init + (item * x_offset);

			Pen.fillColor = Color(0.3, 0.3, 0.3, 0.5);
		    Pen.moveTo(x_i@y_init);
			Pen.lineTo((x_i + kwidth)@y_init);
			Pen.lineTo((x_i + kwidth)@(y_init + kheight));
		    Pen.lineTo((x_i + kwidth -r)@(y_init + kheight + r));  //    /
			Pen.lineTo((x_i + r)@(y_init + kheight + r));          // \
			Pen.lineTo(x_i@(y_init + kheight));

			Pen.fill;
		}
	};

	// LEDS ///////
	// - notes, in order
	Color.red.setFill;
    Pen.addOval(Rect(272, 392, 12, 12));  //  C
    Pen.addOval(Rect(301, 322, 12, 12));  //  C#
    Pen.addOval(Rect(332, 392, 12, 12));  //  D
    Pen.addOval(Rect(360, 322, 12, 12));  //  D#
    Pen.addOval(Rect(391, 392, 12, 12));  //  E
	Pen.addOval(Rect(451, 392, 12, 12));  //  F
	Pen.addOval(Rect(480, 322, 12, 12));  //  F#
	Pen.addOval(Rect(510, 392, 12, 12));  //  G
	Pen.addOval(Rect(539, 322, 12, 12));  //  G#
	Pen.addOval(Rect(570, 392, 12, 12));  //  A
	Pen.addOval(Rect(598, 322, 12, 12));  //  A#
    Pen.addOval(Rect(629, 392, 12, 12));  //  B
    Pen.addOval(Rect(689, 392, 12, 12));  //  C'
    Pen.fill;

	// PITCH MODE LED
	Color.red.setFill;
    Pen.addOval(Rect(185, 329, 12, 12));
	Pen.fill;

	// FUNCTION MODE LED
	Color.red.setFill;
    Pen.addOval(Rect(221, 392, 12, 12));
	Pen.fill;

	// BATTERY LED
	Color.red.setFill;
    Pen.addOval(Rect(79, 392, 12, 12));
	Pen.fill;

	// TIME MODE LED
	Color.red.setFill;
    Pen.addOval(Rect(841, 321, 12, 12));
	Pen.fill;

	// UP DOWN ACCENT SLIDE
	Color.red.setFill;
    Pen.addOval(Rect(752, 392, 12, 12));
	Pen.addOval(Rect(812, 392, 12, 12));
	Pen.addOval(Rect(871, 392, 12, 12));
	Pen.addOval(Rect(932, 392, 12, 12));
	Pen.fill;

	// red lines
	Pen.use {
		Color(0.1, 0.1, 0.1, 1).set;
		Pen.width = 0.3;
		Pen.beginPath;
		coordinates.do{ |item, idx|
			Pen.line(item[0]@item[1], item[2]@item[3]);
			Pen.stroke
		}
	};

	// some highlight
	Color(0.99, 0.99, 0.99, 0.86).setFill;
    Pen.addRect(Rect(13, 286.8, 1086, 2));
	Pen.fill;

	// some highlight
	Color(0.49, 0.49, 0.49, 0.46).setFill;
    Pen.addRect(Rect(1093, 286.8, 6, 242));
	Pen.fill;

	// some highlight
	Color(0.29, 0.29, 0.29, 0.46).setFill;
    Pen.addRect(Rect(11, 286.8, 6, 241));
	Pen.fill;

	// top some deeplight
	Color(0.59, 0.59, 0.59, 0.13).setFill;
    Pen.addRect(Rect(13, 122, 1086, 4));
	Pen.fill;

	// top some highlight
	Color(0.99, 0.99, 0.99, 0.76).setFill;
    Pen.addRect(Rect(13, 126, 1084, 2));
	Pen.fill;

	// white control lines
	Pen.use {
		var tcoords = [
			[849, 476, 967, 476], [908, 466, 908, 475],
			[735, 372, 840, 372], [787 ,373, 787, 383],
			// vertical splits
			[847,361,847,383], [908,361,908,383],
		];
		Pen.width = 1.3;
		Pen.strokeColor = Color.white;
		Pen.beginPath;
		tcoords.do { |item, idx|
			Pen.line(item[0]@item[1], item[2]@item[3]);
			Pen.stroke;
		};
	};



};

// top row
x_offset = 82;
k = Knob.new(w, Rect(start_x, 58, size, size));
k = Knob.new(w, Rect(start_x + (x_offset*1), 58, size, size));
k = Knob.new(w, Rect(start_x + (x_offset*2), 58, size, size));
k = Knob.new(w, Rect(start_x + (x_offset*3), 58, size, size));
k = Knob.new(w, Rect(start_x + (x_offset*4), 58, size, size));
k = Knob.new(w, Rect(start_x + (x_offset*5), 58, size, size));

// mid row
k = Knob.new(w, Rect(126, 177, 80, 80));  // l 1
k = Knob.new(w, Rect(290, 177, 80, 80));  // l 2
k = Knob.new(w, Rect(453, 177, 80, 80));  // l 3
k = Knob.new(w, Rect(923, 177, 80, 80));  // l 3

// notes, black
b = Button(w, Rect(294, 341, 25, 46));
b = Button(w, Rect(294 + (59.5*1), 341, 25, 46));
b = Button(w, Rect(294 + (59.5*3), 341, 25, 46));
b = Button(w, Rect(294 + (59.5*4), 341, 25, 46));
b = Button(w, Rect(294 + (59.5*5), 341, 25, 46));

// notes, white
whitenotes_y = 411;
b = Button(w, Rect(266, whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*1), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*2), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*3), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*4), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*5), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*6), whitenotes_y, 25, 46));
b = Button(w, Rect(266 + (59.5*7), whitenotes_y, 25, 46));

// left side operator buttons
b = Button(w, Rect(62, 349, 46, 25));  // left most
b = Button(w, Rect(168, 349, 46, 25)); // beside it.
b = Button(w, Rect(51, 412, 69, 46));  // bottom left.
b = Button(w, Rect(157, 411, 25, 46)); // beside it.

// right side operators
b = Button(w, Rect(745, 411, 25, 46));            // left of whitenotes.
b = Button(w, Rect(745 + (59.5*1), 411, 25, 46)); // r beside it.
b = Button(w, Rect(745 + (59.5*2), 411, 25, 46)); // r beside it.
b = Button(w, Rect(745 + (59.5*3), 411, 25, 46)); // r beside it.
b = Button(w, Rect(991, 411, 69, 46));            // wide r beside it.

b = Button(w, Rect(912, 332, 46, 25)); // second from right above right ops.
b = Button(w, Rect(1001, 348, 46, 25)); // r beside it.

/////////// TEXT

// SIZE 11

// tempo BLACK
t = StaticText.new(w, Rect(148, 135, 58, 20)).string_("TEMPO").align_(\left);
t.font = Font("Monaco", 11);
t.stringColor_(Color.gray);

// TRACK - WHITE ON BLACK
t = StaticText.new(w, Rect(266, 138, 42, 14)).string_("TRACK").align_(\center);
t.font = Font("Monaco", 11);
t.background=Color.grey;
t.stringColor_(Color.white);

// patt.group BLACK
t = StaticText.new(w, Rect(322, 135, 158, 20)).string_("PATT.GROUP").align_(\left);
t.font = Font("Monaco", 11);
t.stringColor_(Color.gray);

// mode BLACK
t = StaticText.new(w, Rect(478, 135, 158, 20)).string_("MODE").align_(\left);
t.font = Font("Monaco", 11);
t.stringColor_(Color.gray);

// volume BLACK
t = StaticText.new(w, Rect(941, 135, 158, 20)).string_("VOLUME").align_(\left);
t.font = Font("Monaco", 11);
t.stringColor_(Color.gray);

/////////// font size 9 ( top row )

// LEFT TOP

t = StaticText.new(w, Rect(46, 43, 158, 20)).string_("MIX IN").align_(\left);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(107, 43, 158, 20)).string_("WAVEFORM").align_(\left);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(203, 43, 158, 20)).string_("SYNC IN").align_(\left);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

// TOP ROW

t = StaticText.new(w, Rect(251, 31, 158, 20)).string_("TUNING").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(324, 31, 178, 20)).string_("CUT OFF FREQ.").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(405, 31, 178, 20)).string_("RESONANCE").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(487, 31, 178, 20)).string_("ENV MOD").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(568, 31, 178, 20)).string_("DECAY").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(650, 31, 178, 20)).string_("ACCENT").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

// TOP RIGHT

t = StaticText.new(w, Rect(727, 41, 158, 20)).string_("CV").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(774, 41, 158, 20)).string_("GATE").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(832, 41, 158, 20)).string_("HEADPHONE").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(896, 41, 158, 20)).string_("OUTPUT").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(958, 41, 158, 20)).string_("DC 9V").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

// MID BTTON, RIGHT text
t = StaticText.new(w, Rect(803, 253, 158, 20)).string_("POWER SW").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

// time mode.. SIZE 11
t = StaticText.new(w, Rect(769, 304, 158, 20)).string_("TIME MODE").align_(\center);
t.font = Font("Monaco", 12);
t.stringColor_(Color.gray);

/////// MID BUTTONS

// WHITE ON BLACK, UNDER MODE
t = StaticText.new(w, Rect(535, 176, 35, 12)).string_("WRITE").align_(\center);
t.font = Font("Monaco", 9);
t.background=Color.grey;
t.stringColor_(Color.white);

t = StaticText.new(w, Rect(590, 187, 35, 12)).string_("TRACK").align_(\center);
t.font = Font("Monaco", 9);
t.background=Color.grey;
t.stringColor_(Color.white);

t = StaticText.new(w, Rect(549, 198, 27, 12)).string_("PLAY").align_(\center);
t.font = Font("Monaco", 9);
t.background=Color.grey;
t.stringColor_(Color.white);

// BLACK under mode
t = StaticText.new(w, Rect(483, 222, 158, 20)).string_("PLAY").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(474, 243, 158, 20)).string_("WRITE").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(533, 234, 158, 20)).string_("PATTERN").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

// ENDS OF DIALS
// LEFT SIDE MID
t = StaticText.new(w, Rect(44, 253, 158, 20)).string_("SLOW").align_(\center);
t.font = Font("Monaco", 8);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(130, 253, 158, 20)).string_("FAST").align_(\center);
t.font = Font("Monaco", 8);
t.stringColor_(Color.gray);

// RIGHT SIDE MID
t = StaticText.new(w, Rect(843, 253, 158, 20)).string_("OFF").align_(\center);
t.font = Font("Monaco", 8);
t.stringColor_(Color.gray);

t = StaticText.new(w, Rect(926, 253, 158, 20)).string_("MAX").align_(\center);
t.font = Font("Monaco", 8);
t.stringColor_(Color.gray);

// RUN + BATTERY between led

t = StaticText.new(
	w, Rect(53, 388, 28, 20))
    .string_("RUN").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);

t = StaticText.new(
	w, Rect(94, 388, 38, 20))
    .string_("BATTERY").align_(\center);
t.font = Font("Monaco", 9);
t.stringColor_(Color.gray);


// TRACK PATT GROUP CYPHERS small  SANS SERIF
~cypher_coords = [
	[265, 223, "1"],
	[265, 201, "2"],
	[278, 178, "3"],
	[299, 159, "4"],
	[350, 159, "5"],
	[372, 177, "6"],
	[382, 200, "7"]];

~cypher_coords.do {|item, index|
	t = StaticText.new(w, Rect(item[0], item[1], 12, 12)).string_(item[2]).align_(\center);
	t.font = Font("Monaco", 9);
	t.background = Color.grey;
	t.stringColor_(Color.white);
};

// ROMAN NUMERALs, should be seriffed..
~roman_coords = [
	[252, 213, "I"],
	[280, 159, "II"],
	[371, 159, "III"],
	[397, 213, "IV"]];

~roman_coords.do {|item, index|
	t = StaticText.new(w, Rect(item[0], item[1], 12, 12)).string_(item[2]).align_(\center);
	t.font = Font("Monaco", 9);
	t.stringColor_(Color.gray);
};

// PITCH MODE
t = StaticText.new(w, Rect(113, 303, 158, 20)).string_("PITCH MODE").align_(\center);
t.font = Font("Monaco", 12);
t.stringColor_(Color.white);

// Pitches, white text small
~pitches_xy = [
	[270, 301, "C"],
	[297, 301, "C"],
	  [306, 299, "#"],
	[331, 301, "D"],
	[357, 301, "D"],
	  [366, 299, "#"],
	[389, 301, "E"],
	[448, 301, "F"],
    [476, 301, "F"],
	  [485, 299, "#"],
    [509, 301, "G"],
    [537, 301, "G"],
	  [546, 299, "#"],
    [569, 301, "A"],
    [596, 301, "A"],
	  [605, 299, "#"],
    [628, 301, "B"],
    [687, 301, "C"]
];
~pitches_xy.do{ |item, idx|
	t = StaticText.new(w, Rect(item[0], item[1], 12, 20)).string_(item[2]).align_(\center);
	t.font = Font("Monaco", 11);
	t.stringColor_(Color.white);
};

// FUNCTION
t = StaticText.new(w, Rect(100, 388, 158, 20)).string_("FUNCTION").align_(\center);
t.font = Font("Monaco", 12);
t.stringColor_(Color.gray);

// BAR
t = StaticText.new(
	w, Rect(156, 469, 27, 14)).string_("BAR").align_(\center);
t.font = Font("Monaco", 9);
t.background=Color.grey;
t.stringColor_(Color.white);

// SELECTOR
t = StaticText.new(
	w, Rect(149, 492, 158, 20)).string_("SELECTOR").align_(\center);
t.font = Font("Monaco", 12);
t.stringColor_(Color.gray);


// SELECTOR CYPHERS (BOTTOM ROW)
~selx_offset = 59.4;
~selx = 270;
~sely = 495;

~selector_cyphers = [1,2,3,4,5,6,7,8];
~selector_cyphers.do{|item, index|
	t = StaticText.new(
		w, Rect(~selx + (~selx_offset*index), ~sely, 18, 13))
	    .string_(item).align_(\center);
	t.font = Font("Monaco", 10);
	t.background = Color.grey;
	t.stringColor_(Color.white);
};

// del ins (top and bottom)
~whitemarks = [
	[298, 391, "DEL"],
	[297, 492, "DEL"],
	[356, 391, "INS"],
	[356, 492, "INS"]
];
~whitemarks.do{|item, idx|
	t = StaticText.new(w, Rect(item[0], item[1], 19, 13))
	.string_(item[2]).align_(\center);
	t.font = Font("Monaco", 9);
	t.stringColor_(Color.white);
};

// TEXT left side non-Italic
t = StaticText.new(
	w, Rect(50, 466, 68, 20)).string_("RUN / STOP").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

t = StaticText.new(
	w, Rect(65, 307, 68, 20)).string_("BAR RESET").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

t = StaticText.new(
	w, Rect(40, 328, 88, 20)).string_("PATTERN CLEAR").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// NORMAL MODE TEXT
t = StaticText.new(
	w, Rect(196, 407, 48, 27)).string_("NORMAL MODE").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// STEP
t = StaticText.new(
	w, Rect(734, 467, 48, 20)).string_("STEP").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// WRITE / NEXT
t = StaticText.new(
	w, Rect(980, 467, 88, 20))
    .string_("WRITE / NEXT").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// TAP
t = StaticText.new(
	w, Rect(1010, 493, 30, 20))
    .string_("TAP").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// BACK
t = StaticText.new(
	w, Rect(1009, 328, 28, 20))
    .string_("BACK").align_(\center);
t.font = Font("Monaco", 10);
t.stringColor_(Color.gray);

// RED TEXT
t = StaticText.new(
	w, Rect(207, 463, 48, 27)).string_("PATTERN").align_(\center);
t.font = Font("Monaco", 11);
t.stringColor_(redCol);

// red pattern indicators
~red_x_start = 273;
8.do{ |idx|
	t = StaticText.new(
		w, Rect(
			~red_x_start + (idx * 59.5),
			463,
			10,
			27)).string_(idx+1).align_(\center);
	t.font = Font("Monaco", 11);
	t.stringColor_(redCol);

};

// PATT. SECTION red
t = StaticText.new(
	w, Rect(867, 469, 82, 27)).string_("PATT. SECTION").align_(\center);
t.font = Font("Monaco", 11);
t.stringColor_(redCol);

[872, 932].do{|xpos, idx|
	t = StaticText.new(
		w, Rect(xpos, 458, 12, 27)).string_(["A","B"][idx]).align_(\center);
	t.font = Font("Monaco", 9);
	t.stringColor_(redCol);
};

// TRANSPOSE DOWN UP ACCENT SLIDE (WHITE ON BLACK)
~whitetext = [
	//[x, y, w, text],
	[752, 353, 70, "TRANSPOSE"],
	[741, 365, 34, "DOWN"],
	[806, 365, 24, "UP"],
    [855, 359, 44, "ACCENT"],
    [919, 359, 30, "SLIDE"],
];
~whitetext.do{ |item, idx|
	t = StaticText.new(
		w, Rect(item[0], item[1], item[2], 27))
	    .string_(item[3])
	    .align_(\center);
	t.font = Font("Monaco", 10);
	t.stringColor_(Color.white);
};

// black, smallest tripplet text
t = StaticText.new(
	w, Rect(814, 474, 8, 27))
    .string_("3")
    .align_(\center);
t.font = Font("Monaco", 8);
t.stringColor_(Color.gray);


w.refresh;


)
