   PROGRAM 4
   BR L1
L0:
   PROC 1
   LDLADDR 8
   LDCB 1
   STOREB
   LDLADDR 8
   LOADB
   PUTBYTE
   LDCSTR "   "
   PUTSTR
   RET 0
L1:
   LDGADDR 0
   LDCINT 5
   STOREW
   CALL L0
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   HALT
