#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "header.h"

struct entry* Head;
struct entry *newNode(int new_data, char* name)
{
    /* allocate node */
    struct entry* new_node =
    (struct entry*) malloc(sizeof(struct entry));
    /* put in the data  */
    new_node->count  = new_data;
    new_node->quote  = name;
    new_node->next =  NULL;
    return new_node;
}

void sortedInsert(struct entry** head_ref, struct entry* new_node)
{
    struct entry* current;
    /* Special case for the head end */
    if (*head_ref == NULL || (*head_ref)->count > new_node->count)
    {
        new_node->next = *head_ref;
        *head_ref = new_node;
    }
    else if((*head_ref)->count == new_node->count)return;
    else
    {
        current = *head_ref;
        while (current->next!=NULL &&
               current->next->count < new_node->count)
        {
            current = current->next;
        }
        if((current->count) == (new_node->count))
        {
            new_node = NULL;
            current->next = current->next;
        }
        else
        {
            new_node->next = current->next;
            current->next = new_node;
        }
    }
}

void process(char* pStr)
{
    
    int k;
    k=(int)strlen(pStr);
    char *p;
    p=pStr;
    struct entry *new_node = newNode(k, pStr);
    sortedInsert(&Head, new_node);
    
}


