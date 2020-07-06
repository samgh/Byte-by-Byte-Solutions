CC= g++

CPP11_PROGRAMS= AutocompleteModern \
	IntToRoman \
        LinkedListCycle \
	autocomplete

PROGRAMS= ClockAngle \
	ConsecutiveArray \
	Fibonacci \
        FindDuplicates \
        FizzBuzz \
        GrayCode \
        OnesInBinary \
        PrintReversedList \
        ReverseStack \
        SwapVariables \
        TwoMissing 

all: $(CPP11_PROGRAMS) $(PROGRAMS)

$(CPP11_PROGRAMS):
	$(CC) -std=c++11 $@.cpp -o $@

$(PROGRAMS):
	$(CC) $@.cpp -o $@

clean:
	rm -v $(CPP11_PROGRAMS) $(PROGRAMS)

