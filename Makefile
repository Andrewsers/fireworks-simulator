#
# Copyright (C) 2011,2012  Diego Silva
#

# Manifest FIle
MANIFEST := MANIFEST.MF
COMPILER := javac

# Directories
SRCDIR := src/
BINDIR := bin/
OUTDIR := out/


# Parameters
FLAGS_COMPILER := -sourcepath $(SRCDIR)
FLAGS_JAR := $(MANIFEST) -C bin/ ps -C bin/ util

# Sources and its objects
SRC := src/ps/ParticleSystemMain.java
BIN := bin/ps/ParticleSystemMain.class

# all
all: $(OUTDIR)FireworksSimulator.jar

# Jar
$(OUTDIR)FireworksSimulator.jar: $(BIN)
	jar -cvfm $@ $(FLAGS_JAR)

# Classes
%.class: %.java
	$(COMPILER) $(FLAGS_COMPILER) $< -d $(BINDIR)

# Clear
clear:
	rm -r $(BINDIR)* $(OUTDIR)*


