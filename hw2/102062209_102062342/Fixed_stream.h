
/* stream.h code */


#include <stdio.h>
#define SUCCEED 1
#define FAIL 0

typedef struct stream_type {FILE *fp;
                               int  stream_ind;
                               char stream[80];
                            } *character_stream;
typedef
       int BOOLEAN;
typedef
       char CHARACTER;
typedef
       char *string;

extern char get_char();
extern char unget_char();
extern int is_end_of_character_stream();
extern character_stream open_character_stream();

